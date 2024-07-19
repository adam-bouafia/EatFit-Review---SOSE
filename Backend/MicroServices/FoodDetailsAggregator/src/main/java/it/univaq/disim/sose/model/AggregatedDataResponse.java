package it.univaq.disim.sose.model;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;



@Data
public class AggregatedDataResponse {

    // A field to store aggregated rating data
    private AggregatedRatingData aggregatedRatingData;

    // Getter method for aggregatedRatingData
    public AggregatedRatingData getAggregatedRatingData() {
        return aggregatedRatingData;
    }

    // Setter method for aggregatedRatingData
    public void setAggregatedRatingData(AggregatedRatingData aggregatedRatingData) {
        this.aggregatedRatingData = aggregatedRatingData;
    }

}
