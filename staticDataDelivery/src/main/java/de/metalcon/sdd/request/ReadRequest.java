package de.metalcon.sdd.request;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONValue;

import de.metalcon.common.JsonPrettyPrinter;
import de.metalcon.common.JsonString;
import de.metalcon.sdd.IdDetail;
import de.metalcon.sdd.error.ReadRequestNoQuerySddError;
import de.metalcon.sdd.error.ReadRequestQueueActionSddError;
import de.metalcon.sdd.server.Server;

public class ReadRequest extends Request {
    
    final public static char queryDelimeter = ',';

    private String query;
    
    public ReadRequest(Server server) {
        super(server);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    protected Map<String, Object> runHttpAction() {
        Map<String, Object> result = new HashMap<String, Object>();

        if (query == null)
            throw new ReadRequestNoQuerySddError();
        for (String idDetail : query.split(String.valueOf(queryDelimeter))) {
            IdDetail entity = new IdDetail(idDetail);
            result.put(idDetail, new JsonString(server.readEntity(entity)));
        }

        return result;
    }

    @Override
    public void runQueueAction() {
        throw new ReadRequestQueueActionSddError();
    }

    public static void main(String[] args) throws InterruptedException {
        Server s = new Server();
        s.start(); 
        
        ReadRequest r = new ReadRequest(s);
        r.setQuery("11233033e2b36cff:line,2f364c13c0114e16:line,ce0058ac39a33616:profile");
        String json = JSONValue.toJSONString(r.runHttp());
        json = JsonPrettyPrinter.prettyPrintJson(json);
        System.out.println(json);
        Thread.sleep(100);
        
        s.stop();
    }

}
