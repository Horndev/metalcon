package de.metalcon.sdd.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import de.metalcon.common.EntityType;
import de.metalcon.common.JsonOrderedFactory;
import de.metalcon.common.Muid;
import de.metalcon.sdd.Detail;
import de.metalcon.sdd.IdDetail;
import de.metalcon.sdd.server.Server;
import de.metalcon.sdd.tomcat.Servlet;

public abstract class Entity {
    
    protected Server server;
    
    protected boolean jsonGenerated;
    
    protected Map<Detail, String> json;
    
    private Muid id;
    
    public Entity(Server server) {
        this.server = server;
        jsonGenerated = false;
        json = new LinkedHashMap<Detail, String>();
    }
    
    public void loadFromId(Muid id) {
        String json = server.readEntity(new IdDetail(id, Detail.FULL));
        loadFromJson(json);
    }
    
    public abstract void loadFromJson(String json);
    
    public abstract void loadFromCreateParams(Map<String, String[]> params);
    
    public abstract void loadFromUpdateParams(Map<String, String[]> params);
    
    protected static String getParam(Map<String, String[]> params, String key) {
        return getParam(params, key, false);
    }
    
    protected static String getParam(Map<String, String[]> params, String key,
                                     boolean optional) {
        return Servlet.getParam(params, key, optional);
    }
    
    protected static Map<String, String> parseJson(String json) {
        try {
            JSONParser parser = new JSONParser();
            @SuppressWarnings("unchecked")
            Map<String, String> entity = (Map<String, String>)
                    parser.parse(json, new JsonOrderedFactory());
            return entity;
        } catch (ParseException e) {
            // TODO: handle this
            throw new RuntimeException();
        } catch (ClassCastException e) {
            // TODO: handle this
            throw new RuntimeException();
        }
    }

    protected abstract void generateJson();
    
    public String getJson(Detail detail) {
        if (!jsonGenerated)
            generateJson();
        
        return json.get(detail);
    }
    
    public Muid getId() {
        return id;
    }

    public void setId(Muid id) {
        this.id = id;
    }
    
    public static Entity newEntityByType(EntityType type, Server server) {
        switch (type) {
            case CITY:              return new City(server);
            case PERSON:            return new Person(server);
                
            case NONE:
            default:
                // TODO: handle this
                throw new RuntimeException();
        }
    }
    
}