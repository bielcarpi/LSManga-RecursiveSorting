/**
 * There will be 6 different datasets we can read:
 * <ul>
 *     <li>S</li>
 *     <li>M</li>
 *     <li>L</li>
 *     <li>XL</li>
 *     <li>XXL</li>
 *     <li>XXXL</li>
 * </ul>
 *
 * <p>The ones that will always exist will be the S, M and L datasets. Other ones need to be build previously.</p>
 */
public enum Dataset {
    S(Dataset.relativePath + "series_s.json", 50),
    M(Dataset.relativePath + "series_m.json", 22450),
    L(Dataset.relativePath + "series_l.json", 69400),
    XL(Dataset.relativePath + "series_xl.json", 100000),
    XXL(Dataset.relativePath + "series_xxl.json", 250000),
    XXXL(Dataset.relativePath + "series_xxxl.json", 500000);

    static final String relativePath = "resources/";
    String path;
    int numElements;
    Dataset(String path, int numElements){
        this.path = path;
        this.numElements = numElements;
    }
}
