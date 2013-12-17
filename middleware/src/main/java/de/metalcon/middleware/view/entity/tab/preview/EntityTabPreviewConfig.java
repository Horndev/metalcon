package de.metalcon.middleware.view.entity.tab.preview;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EntityTabPreviewConfig {

    @Bean
    @Scope("prototype")
    public AboutTabPreview aboutTabPreview() {
        return new AboutTabPreview();
    }

    @Bean
    @Scope("prototype")
    public NewsfeedTabPreview newsfeedTabPreview() {
        return new NewsfeedTabPreview();
    }

    @Bean
    @Scope("prototype")
    public BandsTabPreview bandsTabPreview() {
        return new BandsTabPreview();
    }

    @Bean
    @Scope("prototype")
    public RecordsTabPreview recordsTabPreview() {
        return new RecordsTabPreview();
    }

    @Bean
    @Scope("prototype")
    public TracksTabPreview tracksTabPreview() {
        return new TracksTabPreview();
    }

    @Bean
    @Scope("prototype")
    public ReviewsTabPreview reviewsTabPreview() {
        return new ReviewsTabPreview();
    }

    @Bean
    @Scope("prototype")
    public VenuesTabPreview venuesTabPreview() {
        return new VenuesTabPreview();
    }

    @Bean
    @Scope("prototype")
    public EventsTabPreview eventsTabPreview() {
        return new EventsTabPreview();
    }

    @Bean
    @Scope("prototype")
    public UsersTabPreview usersTabPreview() {
        return new UsersTabPreview();
    }

    @Bean
    @Scope("prototype")
    public PhotosTabPreview photosTabPreview() {
        return new PhotosTabPreview();
    }

    @Bean
    @Scope("prototype")
    public RecommendationsTabPreview recommendationsTabPreview() {
        return new RecommendationsTabPreview();
    }

    @Bean
    public EntityTabPreviewManager entityTabPreviewManager() {
        return new EntityTabPreviewManager() {

            @Override
            public AboutTabPreview createAboutTabPreview() {
                return aboutTabPreview();
            }

            @Override
            public NewsfeedTabPreview createNewsfeedTabPreview() {
                return newsfeedTabPreview();
            }

            @Override
            public BandsTabPreview createBandsTabPreview() {
                return bandsTabPreview();
            }

            @Override
            public RecordsTabPreview createRecordsTabPreview() {
                return recordsTabPreview();
            }

            @Override
            public TracksTabPreview createTracksTabPreview() {
                return tracksTabPreview();
            }

            @Override
            public ReviewsTabPreview createReviewsTabPreview() {
                return reviewsTabPreview();
            }

            @Override
            public VenuesTabPreview createVenuesTabPreview() {
                return venuesTabPreview();
            }

            @Override
            public EventsTabPreview createEventsTabPreview() {
                return eventsTabPreview();
            }

            @Override
            public UsersTabPreview createUsersTabPreview() {
                return usersTabPreview();
            }

            @Override
            public PhotosTabPreview createPhotosTabPreview() {
                return photosTabPreview();
            }

            @Override
            public RecommendationsTabPreview createRecomendationsTabPreview() {
                return recommendationsTabPreview();
            }

        };
    }

}