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
    XS("series_xs.json"),
    S("series_s.json"),
    M("series_m.json"),
    L("series_l.json"),
    XL("series_xl.json"),
    XXL("series_xxl.json"),
    XXXL("series_xxxl.json");

    String path;
    Dataset(String path){
        this.path = path;
    }
}
