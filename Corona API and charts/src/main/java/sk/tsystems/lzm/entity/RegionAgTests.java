package sk.tsystems.lzm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegionAgTests {

    @Id
    @Column(nullable = false)
    private String id;
    @JsonProperty("region_id")
    @ManyToOne
    @JoinColumn(name = "Region.id")
    private Region region;
    @JsonProperty("positivity_rate")
    @Column(nullable = false)
    private float positivityRate;
    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date updatedAt;
    @JsonProperty("published_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date publishedOn;
    @JsonProperty("positives_count")
    @Column(nullable = false)
    private int positivesCount;
    @JsonProperty("negatives_count")
    @Column(nullable = false)
    private int negativesCount;
    @JsonProperty("positives_sum")
    @Column(nullable = false)
    private int positivesSum;
    @JsonProperty("negatives_sum")
    @Column(nullable = false)
    private int negativesSum;

    public RegionAgTests(String id, Region region, float positivityRate, Date updatedAt, Date publishedOn, int positivesCount, int negativesCount, int positivesSum, int negativesSum) {
        this.id = id;
        this.region = region;
        this.positivityRate = positivityRate;
        this.updatedAt = updatedAt;
        this.publishedOn = publishedOn;
        this.positivesCount = positivesCount;
        this.negativesCount = negativesCount;
        this.positivesSum = positivesSum;
        this.negativesSum = negativesSum;
    }
    public RegionAgTests(String id) {
        this.id = id;
    }

    public RegionAgTests() {
    }

    public String getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public float getPositivityRate() {
        return positivityRate;
    }

    public void setPositivityRate(float positivityRate) {
        this.positivityRate = positivityRate;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public int getPositivesCount() {
        return positivesCount;
    }

    public void setPositivesCount(int positivesCount) {
        this.positivesCount = positivesCount;
    }

    public int getNegativesCount() {
        return negativesCount;
    }

    public void setNegativesCount(int negativesCount) {
        this.negativesCount = negativesCount;
    }

    public int getPositivesSum() {
        return positivesSum;
    }

    public void setPositivesSum(int positivesSum) {
        this.positivesSum = positivesSum;
    }

    public int getNegativesSum() {
        return negativesSum;
    }

    public void setNegativesSum(int negativesSum) {
        this.negativesSum = negativesSum;
    }

    @Override
    public String toString() {
        return "RegionAgTests{" +
                "id='" + id + '\'' +
                ", region=" + region +
                ", positivityRate=" + positivityRate +
                ", updatedAt=" + updatedAt +
                ", publishedOn=" + publishedOn +
                ", positivesCount=" + positivesCount +
                ", negativesCount=" + negativesCount +
                ", positivesSum=" + positivesSum +
                ", negativesSum=" + negativesSum +
                '}';
    }
}
