package de.metalcon.middleware.controller.entity.impl.user;

import org.springframework.stereotype.Component;

import de.metalcon.middleware.controller.entity.generator.RecommendationsTabGenerator;
import de.metalcon.middleware.domain.Muid;
import de.metalcon.middleware.view.entity.tab.content.EntityTabContent;
import de.metalcon.middleware.view.entity.tab.preview.EntityTabPreview;

@Component
public class UserRecommendationsTabGenerator extends
        RecommendationsTabGenerator {

    @Override
    public void generateTabContent(EntityTabContent tabContent, Muid muid) {
        // TODO Auto-generated method stub
    }

    @Override
    public void genereteTabPreview(EntityTabPreview tabPreview, Muid muid) {
        // TODO Auto-generated method stub
    }

}
