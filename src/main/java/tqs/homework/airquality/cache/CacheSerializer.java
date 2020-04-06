package tqs.homework.airquality.cache;

/**
 * @author Vasco Ramos
 * @date 06/04/20
 * @time 20:56
 */

public class CacheSerializer {

    private Cache cache;

    public CacheSerializer(Cache cache) {
        this.cache = cache;
    }

    public int getNumberOfRequests() {
        return this.cache.getNumberOfRequests();
    }

    public int getNumberOfHits() {
        return this.cache.getNumberOfHits();
    }

    public int getNumberOfMisses() {
        return this.cache.getNumberOfMisses();
    }


}
