/**
 * There will be 7 different datasets we can read:
 * <ul>
 *     <li>XS</li>
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
    XS(Dataset.relativePath + "series_xs.json"),
    S(Dataset.relativePath + "series_s.json"),
    M(Dataset.relativePath + "series_m.json"),
    L(Dataset.relativePath + "series_l.json"),
    XL(Dataset.relativePath + "series_xl.json"),
    XXL(Dataset.relativePath + "series_xxl.json"),
    XXXL(Dataset.relativePath + "series_xxxl.json");

    static final String relativePath = "resources/";
    String path;
    Dataset(String path){
        this.path = path;
    }
}
