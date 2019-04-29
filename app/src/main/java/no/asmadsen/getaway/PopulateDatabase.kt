package no.asmadsen.getaway

import no.asmadsen.getaway.room.entities.*

private data class _Region(val name: String, val countries: List<String>)

private data class _Country(val name: String, val code: String, val cities: List<_City>)

private data class _City(val name: String, val code: String, val airports: List<_Airport>)

private data class _Airport(val name: String, val iata: String, val latitude: Double, val longitude: Double)

fun populateDatabase(database: MyDatabase) {
    val countries = listOf(
        _Country(
            "Bahamas", "BS", listOf(
                _City(
                    "Nassau", "NAS", listOf(
                        _Airport("Nassau", "NAS", 25.0389995575, -77.46620178219999)
                    )
                )
            )
        ),
        _Country(
            "Canada", "CA", listOf(
                _City(
                    "Calgary, AB", "YYC", listOf(
                        _Airport("Calgary Intl", "YYC", 51.113899231, -114.019996643)
                    )
                ),
                _City(
                    "Edmonton, AB", "YEA", listOf(
                        _Airport("Edmonton Intl", "YEG", 53.309700012200004, -113.580001831)
                    )
                ),
                _City(
                    "Fort McMurray, AB", "YMM", listOf(
                        _Airport("Fort McMurray", "YMM", 56.653301239, -111.222000122)
                    )
                ),
                _City(
                    "Halifax, NS", "YHZ", listOf(
                        _Airport("Stanfield", "YHZ", 44.8807983398, -63.5085983276)
                    )
                ),
                _City(
                    "Kelowna, BC", "YLW", listOf(
                        _Airport("Kelowna Intl", "YLW", 49.9561004639, -119.377998352)
                    )
                ),
                _City(
                    "London, ON", "YXU", listOf(
                        _Airport("London Intl", "YXU", 43.035599, -81.1539)
                    )
                ),
                _City(
                    "Montreal, QC", "YMQ", listOf(
                        _Airport("Pierre E. Trudeau", "YUL", 45.4706001282, -73.7407989502)
                    )
                ),
                _City(
                    "Ottawa, ON", "YOW", listOf(
                        _Airport("Macdonald Cartier", "YOW", 45.3224983215332, -75.66919708251953)
                    )
                ),
                _City(
                    "Quebec, QC", "YQB", listOf(
                        _Airport("Jean Lesage", "YQB", 46.7911, -71.393303)
                    )
                ),
                _City(
                    "Regina, SK", "YQR", listOf(
                        _Airport("Regina Intl", "YQR", 50.43190002441406, -104.66600036621094)
                    )
                ),
                _City(
                    "SaintJohn", "YSJ", listOf(
                        _Airport("Saint John", "YSJ", 45.31610107421875, -65.89029693603516)
                    )
                ),
                _City(
                    "Saskatoon, SK", "YXE", listOf(
                        _Airport("J. G. Diefenbaker", "YXE", 52.170799255371094, -106.69999694824219)
                    )
                ),
                _City(
                    "St Johns, NL", "YYT", listOf(
                        _Airport("St Johns Intl", "YYT", 47.618598938, -52.7518997192)
                    )
                ),
                _City(
                    "Sudbury, ON", "YSB", listOf(
                        _Airport("Sudbury", "YSB", 46.625, -80.79889678955078)
                    )
                ),
                _City(
                    "Sydney", "YQY", listOf(
                        _Airport("Sydney", "YQY", 46.1614, -60.047798)
                    )
                ),
                _City(
                    "Thunder Bay, ON", "YQT", listOf(
                        _Airport("Thunder Bay Intl", "YQT", 48.37189865112305, -89.32389831542969)
                    )
                ),
                _City(
                    "Toronto, ON", "YTO", listOf(
                        _Airport("Pearson", "YYZ", 43.6772003174, -79.63059997559999)
                    )
                ),
                _City(
                    "Vancouver, BC", "YVR", listOf(
                        _Airport("Vancouver Intl", "YVR", 49.193901062, -123.183998108)
                    )
                ),
                _City(
                    "Victoria, BC", "YYJ", listOf(
                        _Airport("Victoria Intl", "YYJ", 48.646900177, -123.426002502)
                    )
                ),
                _City(
                    "Winnipeg, MB", "YWG", listOf(
                        _Airport("J. A. Richardson", "YWG", 49.909999847399995, -97.2398986816)
                    )
                )
            )
        ),
        _Country(
            "Cayman Islands", "KY", listOf(
                _City(
                    "Grand Cayman", "GCM", listOf(
                        _Airport("Owen Roberts", "GCM", 19.292800903299998, -81.3576965332)
                    )
                )
            )
        ),
        _Country(
            "Colombia", "CO", listOf(
                _City(
                    "Barranquilla", "BAQ", listOf(
                        _Airport("Ernesto Cortissoz", "BAQ", 10.8896, -74.7808)
                    )
                ),
                _City(
                    "Bogota", "BOG", listOf(
                        _Airport("El Dorado", "BOG", 4.70159, -74.1469)
                    )
                ),
                _City(
                    "Cali", "CLO", listOf(
                        _Airport("Alfonso B Aragon", "CLO", 3.54322, -76.3816)
                    )
                ),
                _City(
                    "Cartagena", "CTG", listOf(
                        _Airport("Rafael Nunez", "CTG", 10.4424, -75.513)
                    )
                ),
                _City(
                    "Medellin", "MDE", listOf(
                        _Airport("Jose Maria Cordova", "MDE", 6.16454, -75.4231)
                    )
                )
            )
        ),
        _Country(
            "Costa Rica", "CR", listOf(
                _City(
                    "San Jose", "SJO", listOf(
                        _Airport("Juan Santa Maria", "SJO", 9.993860244750977, -84.20880126953125)
                    )
                )
            )
        ),
        _Country(
            "Dominican Republic", "DO", listOf(
                _City(
                    "Santo Domingo", "SDQ", listOf(
                        _Airport("Santo Domingo", "SDQ", 18.42970085144, -69.668899536133)
                    )
                )
            )
        ),
        _Country(
            "El Salvador", "SV", listOf(
                _City(
                    "San Salvador", "SAL", listOf(
                        _Airport("El Salvador", "SAL", 13.4409, -89.055702)
                    )
                )
            )
        ),
        _Country(
            "Jamaica", "JM", listOf(
                _City(
                    "Montego Bay", "MBJ", listOf(
                        _Airport("Montego Bay", "MBJ", 18.503700256347656, -77.91339874267578)
                    )
                )
            )
        ),
        _Country(
            "Mexico", "MX", listOf(
                _City(
                    "Cancun", "CUN", listOf(
                        _Airport("Cancun Intl", "CUN", 21.036500930800003, -86.8770980835)
                    )
                ),
                _City(
                    "Guadalajara", "GDL", listOf(
                        _Airport("Miguel Hidalgo", "GDL", 20.521799087524414, -103.31099700927734)
                    )
                ),
                _City(
                    "Mexico City", "MEX", listOf(
                        _Airport("Benito Juarez", "MEX", 19.4363, -99.072098)
                    )
                ),
                _City(
                    "Monterrey", "MTY", listOf(
                        _Airport("Mariano Escobedo", "MTY", 25.7784996033, -100.107002258)
                    )
                )
            )
        ),
        _Country(
            "Panama", "PA", listOf(
                _City(
                    "Panama City", "PTY", listOf(
                        _Airport("Tocumen", "PTY", 9.0713596344, -79.3834991455)
                    )
                )
            )
        ),
        _Country(
            "Puerto Rico", "PR", listOf(
                _City(
                    "San Juan", "SJU", listOf(
                        _Airport("Luis Munoz Marin", "SJU", 18.4393997192, -66.0018005371)
                    )
                )
            )
        ),
        _Country(
            "Sint Maarten", "SX", listOf(
                _City(
                    "Saint Maarten", "SXM", listOf(
                        _Airport("St Maarten", "SXM", 18.041000366200002, -63.1088981628)
                    )
                )
            )
        ),
        _Country(
            "United States", "US", listOf(
                _City(
                    "Akron / Canton, OH", "CAK", listOf(
                        _Airport("Akron / Canton Regional", "CAK", 40.916099548339844, -81.44219970703125)
                    )
                ),
                _City(
                    "Albany, NY", "ALB", listOf(
                        _Airport("Albany Intl", "ALB", 42.74829864501953, -73.80169677734375)
                    )
                ),
                _City(
                    "Albuquerque, NM", "ABQ", listOf(
                        _Airport("Intl Sunport", "ABQ", 35.040199, -106.609001)
                    )
                ),
                _City(
                    "Alexandria LA", "AEX", listOf(
                        _Airport("Alexandria Intl", "AEX", 31.32740020751953, -92.54979705810547)
                    )
                ),
                _City(
                    "Allentown / Bethlehem, PA", "ABE", listOf(
                        _Airport("Lehigh Valley", "ABE", 40.652099609375, -75.44080352783203)
                    )
                ),
                _City(
                    "Amarillo, TX", "AMA", listOf(
                        _Airport("Rick Husband", "AMA", 35.219398, -101.706001)
                    )
                ),
                _City(
                    "Anchorage, AK", "ANC", listOf(
                        _Airport("Ted Stevens", "ANC", 61.174400329589844, -149.99600219726562)
                    )
                ),
                _City(
                    "Appleton, WI", "ATW", listOf(
                        _Airport("Outagamie Country Regional", "ATW", 44.258098602299995, -88.5190963745)
                    )
                ),
                _City(
                    "Arcata / Eureka, CA", "ACV", listOf(
                        _Airport("Cal Redwood Cst-Humboldt Cou", "ACV", 40.978101, -124.109)
                    )
                ),
                _City(
                    "Asheville / Hendersonville, NC", "AVL", listOf(
                        _Airport("Asheville Regional", "AVL", 35.43619918823242, -82.54180145263672)
                    )
                ),
                _City(
                    "Aspen, CO", "ASE", listOf(
                        _Airport("Pitkin County", "ASE", 39.22320175, -106.8690033)
                    )
                ),
                _City(
                    "Atlanta, GA", "ATL", listOf(
                        _Airport("Hartsfield - Jackson", "ATL", 33.6367, -84.428101)
                    )
                ),
                _City(
                    "Augusta, GA", "AGS", listOf(
                        _Airport("Augusta Regional", "AGS", 33.36989974975586, -81.9645004272461)
                    )
                ),
                _City(
                    "Austin, TX", "AUS", listOf(
                        _Airport("Bergstrom", "AUS", 30.194499969482422, -97.6698989868164)
                    )
                ),
                _City(
                    "Bakersfield, CA", "BFL", listOf(
                        _Airport("Meadows Field", "BFL", 35.43360138, -119.0569992)
                    )
                ),
                _City(
                    "Baltimore, MD", "BWI", listOf(
                        _Airport("Baltimore / Washington Intl", "BWI", 39.1754, -76.668297)
                    )
                ),
                _City(
                    "Bangor, ME", "BGR", listOf(
                        _Airport("Bangor Intl", "BGR", 44.80739974975586, -68.8281021118164)
                    )
                ),
                _City(
                    "Baton Rouge, LA", "BTR", listOf(
                        _Airport("Metropolitan", "BTR", 30.533199, -91.149597)
                    )
                ),
                _City(
                    "Beaumont / Port Arthur, TX", "BPT", listOf(
                        _Airport("Jack Brooks Regl", "BPT", 29.9507999420166, -94.02069854736328)
                    )
                ),
                _City(
                    "Bellingham, WA", "BLI", listOf(
                        _Airport("Bellingham Intl", "BLI", 48.79280090332031, -122.53800201416016)
                    )
                ),
                _City(
                    "Billings, MT", "BIL", listOf(
                        _Airport("Logan", "BIL", 45.807701110839844, -108.54299926757812)
                    )
                ),
                _City(
                    "Binghamton, NY", "BGM", listOf(
                        _Airport("Greater Binghampton", "BGM", 42.20869827, -75.97979736)
                    )
                ),
                _City(
                    "Birmingham, AL", "BHM", listOf(
                        _Airport("Shuttlesworth", "BHM", 33.56290054, -86.75350189)
                    )
                ),
                _City(
                    "Bismarck, ND", "BIS", listOf(
                        _Airport("Municipal", "BIS", 46.772701263427734, -100.74600219726562)
                    )
                ),
                _City(
                    "Boise, ID", "BOI", listOf(
                        _Airport("Air Terminal", "BOI", 43.5644, -116.223)
                    )
                ),
                _City(
                    "Boston, MA", "BOS", listOf(
                        _Airport("Logan Int Airport", "BOS", 42.36429977, -71.00520325)
                    )
                ),
                _City(
                    "Bozeman, MT", "BZN", listOf(
                        _Airport("Yellowstone", "BZN", 45.77750015, -111.1529999)
                    )
                ),
                _City(
                    "Buffalo, NY", "BUF", listOf(
                        _Airport("Niagara", "BUF", 42.94049835, -78.73220062)
                    )
                ),
                _City(
                    "Burbank, CA", "BUR", listOf(
                        _Airport("Bob Hope", "BUR", 34.20069885253906, -118.35900115966797)
                    )
                ),
                _City(
                    "Burlington", "BTV", listOf(
                        _Airport("Burlington Intl", "BTV", 44.471900939899996, -73.15329742429999)
                    )
                ),
                _City(
                    "Casper, WY", "CPR", listOf(
                        _Airport("Natrona County", "CPR", 42.90800095, -106.4639969)
                    )
                ),
                _City(
                    "Cedar Rapids, IA", "CID", listOf(
                        _Airport("The Eastern Iowa", "CID", 41.884700775146484, -91.71080017089844)
                    )
                ),
                _City(
                    "Champaign Urbana, IL", "CMI", listOf(
                        _Airport("Uni Of Illinois Willard", "CMI", 40.03919983, -88.27809906)
                    )
                ),
                _City(
                    "Charleston, SC", "CHS", listOf(
                        _Airport("Charleston Intl", "CHS", 32.89860153, -80.04049683)
                    )
                ),
                _City(
                    "Charleston, WV", "CRW", listOf(
                        _Airport("Yeager", "CRW", 38.37310028076172, -81.59320068359375)
                    )
                ),
                _City(
                    "Charlotte, NC", "CLT", listOf(
                        _Airport("Douglas", "CLT", 35.2140007019043, -80.94309997558594)
                    )
                ),
                _City(
                    "Charlottesville, VA", "CHO", listOf(
                        _Airport("Albemarle", "CHO", 38.13859939575195, -78.4529037475586)
                    )
                ),
                _City(
                    "Chattanooga, TN", "CHA", listOf(
                        _Airport("Metropolitan", "CHA", 35.035301208496094, -85.20379638671875)
                    )
                ),
                _City(
                    "Chicago, IL", "CHI", listOf(
                        _Airport("O'Hare", "ORD", 41.9786, -87.9048)
                    )
                ),
                _City(
                    "Chico, CA", "CIC", listOf(
                        _Airport("Municipal", "CIC", 39.79539871, -121.8580017)
                    )
                ),
                _City(
                    "Cincinnati, OH", "CVG", listOf(
                        _Airport("Northern Kentucky", "CVG", 39.0488014221, -84.6678009033)
                    )
                ),
                _City(
                    "Cleveland, OH", "CLE", listOf(
                        _Airport("Hopkins", "CLE", 41.4117012024, -81.8498001099)
                    )
                ),
                _City(
                    "Cody, WY", "COD", listOf(
                        _Airport("Yellowstone Regional", "COD", 44.520198822, -109.024002075)
                    )
                ),
                _City(
                    "College Station, TX", "CLL", listOf(
                        _Airport("Easterwood", "CLL", 30.58860016, -96.36380005)
                    )
                ),
                _City(
                    "Colorado Springs, CO", "COS", listOf(
                        _Airport("Municipal", "COS", 38.805801, -104.700996)
                    )
                ),
                _City(
                    "Columbia, MO", "COU", listOf(
                        _Airport("Columbia Regional", "COU", 38.81809997558594, -92.21959686279297)
                    )
                ),
                _City(
                    "Columbia, SC", "CAE", listOf(
                        _Airport("Metropolitan", "CAE", 33.93880081176758, -81.11949920654297)
                    )
                ),
                _City(
                    "Columbus, OH", "CMH", listOf(
                        _Airport("John Glenn", "CMH", 39.998001, -82.891899)
                    )
                ),
                _City(
                    "Corpus Christi, TX", "CRP", listOf(
                        _Airport("Corpus Christi Intl", "CRP", 27.77039909362793, -97.5011978149414)
                    )
                ),
                _City(
                    "Dallas / Fort Worth, TX", "DFW", listOf(
                        _Airport("Dallas Ft Worth Intl", "DFW", 32.896801, -97.038002)
                    )
                ),
                _City(
                    "Dayton, OH", "DAY", listOf(
                        _Airport("Dayton Intl", "DAY", 39.902400970458984, -84.21939849853516)
                    )
                ),
                _City(
                    "Daytona Beach, FL", "DAB", listOf(
                        _Airport("Daytona Beach Intl", "DAB", 29.179899, -81.058098)
                    )
                ),
                _City(
                    "Denver, CO", "DEN", listOf(
                        _Airport("Denver Intl", "DEN", 39.861698150635, -104.672996521)
                    )
                ),
                _City(
                    "Des Moines, IA", "DSM", listOf(
                        _Airport("Des Moines Intl", "DSM", 41.534000396728516, -93.66310119628906)
                    )
                ),
                _City(
                    "Detroit, MI", "DTT", listOf(
                        _Airport("Metropolitan Wayne County", "DTW", 42.212398529052734, -83.35340118408203),
                        _Airport("Darwin", "DRW", -12.41469955444336, 130.8769989013672)
                    )
                ),
                _City(
                    "Devils Lake, ND", "DVL", listOf(
                        _Airport("Devils Lake Regional", "DVL", 48.11420059, -98.90879822)
                    )
                ),
                _City(
                    "Dickinson, ND", "DIK", listOf(
                        _Airport("T. Roosevelt Regional", "DIK", 46.7974014282, -102.802001953)
                    )
                ),
                _City(
                    "Dubuque, IA", "DBQ", listOf(
                        _Airport("Dubuque Regional", "DBQ", 42.40200043, -90.70950317)
                    )
                ),
                _City(
                    "Duluth / Superior, MN", "DLH", listOf(
                        _Airport("Duluth Intl", "DLH", 46.8420982361, -92.19360351559999)
                    )
                ),
                _City(
                    "Durango, CO", "DRO", listOf(
                        _Airport("La Plata County", "DRO", 37.1515007019, -107.753997803)
                    )
                ),
                _City(
                    "Eau Claire, WI", "EAU", listOf(
                        _Airport("Chippewa Valley Regional", "EAU", 44.86579895019531, -91.48429870605469)
                    )
                ),
                _City(
                    "Elmira / Corning, NY", "ELM", listOf(
                        _Airport("Elmira / Corning Regional", "ELM", 42.1599006652832, -76.8916015625)
                    )
                ),
                _City(
                    "El Paso, TX", "ELP", listOf(
                        _Airport("El Paso Intl", "ELP", 31.80719948, -106.3779984)
                    )
                ),
                _City(
                    "Erie, PA", "ERI", listOf(
                        _Airport("Erie Intl", "ERI", 42.0831270134, -80.1738667488)
                    )
                ),
                _City(
                    "Eugene, OR", "EUG", listOf(
                        _Airport("Mahlon Sweet Field", "EUG", 44.12459945678711, -123.21199798583984)
                    )
                ),
                _City(
                    "Evansville, IN", "EVV", listOf(
                        _Airport("Evansville Regional", "EVV", 38.0369987488, -87.5324020386)
                    )
                ),
                _City(
                    "Fairbanks, AK", "FAI", listOf(
                        _Airport("Fairbanks Intl", "FAI", 64.81510162, -147.8560028)
                    )
                ),
                _City(
                    "Fargo, ND", "FAR", listOf(
                        _Airport("Hector", "FAR", 46.92070007324219, -96.81580352783203)
                    )
                ),
                _City(
                    "Fayetteville, NC", "FAY", listOf(
                        _Airport("Fayetteville Regional", "FAY", 34.9911994934082, -78.88030242919922)
                    )
                ),
                _City(
                    "Fayetteville, AR", "XNA", listOf(
                        _Airport("Fayetteville NW Arkansas Rgn", "XNA", 36.281898, -94.306801)
                    )
                ),
                _City(
                    "Flint, MI", "FNT", listOf(
                        _Airport("Bishop", "FNT", 42.96540069580078, -83.74359893798828)
                    )
                ),
                _City(
                    "Fort Lauderdale, FL", "FLL", listOf(
                        _Airport("Fort Lauderdale Intl", "FLL", 26.072599, -80.152702)
                    )
                ),
                _City(
                    "Fort Myers, FL", "FMY", listOf(
                        _Airport("Southwest Florida Regional", "RSW", 26.53619956970215, -81.75520324707031)
                    )
                ),
                _City(
                    "Fort Wayne, IN", "FWA", listOf(
                        _Airport("Fort Wayne Intl", "FWA", 40.97850037, -85.19509888)
                    )
                ),
                _City(
                    "Fresno, CA", "FAT", listOf(
                        _Airport("Yosemite", "FAT", 36.77619934082031, -119.71800231933594)
                    )
                ),
                _City(
                    "Gainesville, FL", "GNV", listOf(
                        _Airport("Gainesville Regional", "GNV", 29.6900997162, -82.2717971802)
                    )
                ),
                _City(
                    "Gillette, WY", "GCC", listOf(
                        _Airport("Campbell County", "GCC", 44.348899841299996, -105.539001465)
                    )
                ),
                _City(
                    "Grand Junction, CO", "GJT", listOf(
                        _Airport("Grand Junction Regional", "GJT", 39.1223983765, -108.527000427)
                    )
                ),
                _City(
                    "Grand Rapids, MI", "GRR", listOf(
                        _Airport("Gerald R. Ford", "GRR", 42.88079834, -85.52279663)
                    )
                ),
                _City(
                    "Great Falls, MT", "GTF", listOf(
                        _Airport("Great Falls Intl", "GTF", 47.48199844, -111.3710022)
                    )
                ),
                _City(
                    "Green Bay, WI", "GRB", listOf(
                        _Airport("Austin Straubel", "GRB", 44.48509979248047, -88.12960052490234)
                    )
                ),
                _City(
                    "Greensboro / High Point, NC", "GSO", listOf(
                        _Airport("Piedmont Triad", "GSO", 36.097801208496094, -79.93730163574219)
                    )
                ),
                _City(
                    "Greenville / Spartanburg, SC", "GSP", listOf(
                        _Airport("Greenville / Spartanburg Intl", "GSP", 34.8956985474, -82.2189025879)
                    )
                ),
                _City(
                    "Gulfport / Biloxi, MS", "GPT", listOf(
                        _Airport("Biloxi Regional", "GPT", 30.40730094909668, -89.07009887695312)
                    )
                ),
                _City(
                    "Gunnison, CO", "GUC", listOf(
                        _Airport("Crested Butte Regional", "GUC", 38.53390121, -106.9329987)
                    )
                ),
                _City(
                    "Hancock, MI", "CMX", listOf(
                        _Airport("Houghton County Meml", "CMX", 47.168399810791016, -88.48909759521484)
                    )
                ),
                _City(
                    "Harlingen, TX", "HRL", listOf(
                        _Airport("Valley", "HRL", 26.228500366210938, -97.65440368652344)
                    )
                ),
                _City(
                    "Harrisburg, PA", "HAR", listOf(
                        _Airport("Harrisburg Intl", "MDT", 40.1935005188, -76.7633972168)
                    )
                ),
                _City(
                    "Hartford, CT", "HFD", listOf(
                        _Airport("Bradley", "BDL", 41.9388999939, -72.68319702149999)
                    )
                ),
                _City(
                    "Hayden, CO", "HDN", listOf(
                        _Airport("Yampa Valley", "HDN", 40.48120117, -107.2180023)
                    )
                ),
                _City(
                    "Hays, KS", "HYS", listOf(
                        _Airport("Hays Regional", "HYS", 38.84220123, -99.27320099)
                    )
                ),
                _City(
                    "Helena, MT", "HLN", listOf(
                        _Airport("Helena Regional", "HLN", 46.6068000793457, -111.98300170898438)
                    )
                ),
                _City(
                    "Hilo, HI", "ITO", listOf(
                        _Airport("Hilo Intl", "ITO", 19.721399307250977, -155.04800415039062)
                    )
                ),
                _City(
                    "Honolulu, HI", "HNL", listOf(
                        _Airport("Honolulu Intl", "HNL", 21.32062, -157.924228)
                    )
                ),
                _City(
                    "Hoolehua, HI", "MKK", listOf(
                        _Airport("Molokai", "MKK", 21.15290069580078, -157.0959930419922)
                    )
                ),
                _City(
                    "Houston, TX", "HOU", listOf(
                        _Airport("G. Bush Intercont", "IAH", 29.984399795532227, -95.34140014648438)
                    )
                ),
                _City(
                    "Huntsville, AL", "HSV", listOf(
                        _Airport("Huntsville Intl", "HSV", 34.637199401855, -86.775100708008)
                    )
                ),
                _City(
                    "Idaho Falls, ID", "IDA", listOf(
                        _Airport("Idaho Falls Regional", "IDA", 43.514599, -112.070999)
                    )
                ),
                _City(
                    "Indianapolis, IN", "IND", listOf(
                        _Airport("Indianapolis Intl", "IND", 39.7173, -86.294403)
                    )
                ),
                _City(
                    "Ithaca, NY", "ITH", listOf(
                        _Airport("Tompkins Regional", "ITH", 42.49100112915039, -76.4583969116211)
                    )
                ),
                _City(
                    "Jackson, MS", "JAN", listOf(
                        _Airport("M.W. Evers", "JAN", 32.3111991882, -90.0758972168)
                    )
                ),
                _City(
                    "Jacksonville, FL", "JAX", listOf(
                        _Airport("Jacksonville Intl", "JAX", 30.49410057067871, -81.68789672851562)
                    )
                ),
                _City(
                    "Jackson, WY", "JAC", listOf(
                        _Airport("Jackson Hole", "JAC", 43.6072998046875, -110.73799896240234)
                    )
                ),
                _City(
                    "Jamestown, ND", "JMS", listOf(
                        _Airport("Jamestown Regional", "JMS", 46.92969894, -98.67819977)
                    )
                ),
                _City(
                    "Juneau, AK", "JNU", listOf(
                        _Airport("Juneau Intl", "JNU", 58.35499954223633, -134.5760040283203)
                    )
                ),
                _City(
                    "Kahului, HI", "OGG", listOf(
                        _Airport("Maui", "OGG", 20.8986, -156.429993)
                    )
                ),
                _City(
                    "Kalamazoo / Battle Creek, MI", "AZO", listOf(
                        _Airport("Battle Creek Intl", "AZO", 42.234901428222656, -85.5521011352539)
                    )
                ),
                _City(
                    "Kalispell, MT", "FCA", listOf(
                        _Airport("Glacier Park", "FCA", 48.31050109863281, -114.25599670410156)
                    )
                ),
                _City(
                    "Kansas City, MO", "MKC", listOf(
                        _Airport("Kansas City Intl", "MCI", 39.2976, -94.713898)
                    )
                ),
                _City(
                    "Lihue, HI", "LIH", listOf(
                        _Airport("Kauai", "LIH", 21.97599983215332, -159.33900451660156)
                    )
                ),
                _City(
                    "Ketchikan, AK", "KTN", listOf(
                        _Airport("Ketchikan Intl", "KTN", 55.35559845, -131.7140045)
                    )
                ),
                _City(
                    "Key West, FL", "EYW", listOf(
                        _Airport("Key West Intl", "EYW", 24.556100845336914, -81.75959777832031)
                    )
                ),
                _City(
                    "Klamath Falls", "LMT", listOf(
                        _Airport("Klamath Falls", "LMT", 42.156101, -121.733002)
                    )
                ),
                _City(
                    "Knoxville, TN", "TYS", listOf(
                        _Airport("McGhee Tyson", "TYS", 35.81100082, -83.9940033)
                    )
                ),
                _City(
                    "Kailua / Kona, HI", "KOA", listOf(
                        _Airport("Ellison Onizuka", "KOA", 19.738783, -156.045603)
                    )
                ),
                _City(
                    "Lafayette, LA", "LFT", listOf(
                        _Airport("Lafayette Regional", "LFT", 30.20529938, -91.98760223)
                    )
                ),
                _City(
                    "Lanai City, HI", "LNY", listOf(
                        _Airport("Lanai", "LNY", 20.785600662231445, -156.9510040283203)
                    )
                ),
                _City(
                    "Lansing, MI", "LAN", listOf(
                        _Airport("Capital Region Intl", "LAN", 42.77870178222656, -84.58740234375)
                    )
                ),
                _City(
                    "Laramie, WY", "LAR", listOf(
                        _Airport("Laramie Regional", "LAR", 41.31209945678711, -105.67500305175781)
                    )
                ),
                _City(
                    "Laredo, TX", "LRD", listOf(
                        _Airport("Laredo Intl", "LRD", 27.543800354003906, -99.46160125732422)
                    )
                ),
                _City(
                    "Las Vegas, NV", "LAS", listOf(
                        _Airport("McCarran", "LAS", 36.08010101, -115.1520004)
                    )
                ),
                _City(
                    "Lawton, OK", "LAW", listOf(
                        _Airport("Lawton Regional", "LAW", 34.5676994324, -98.4166030884)
                    )
                ),
                _City(
                    "Lexington, KY", "LEX", listOf(
                        _Airport("Blue Grass", "LEX", 38.0364990234375, -84.60590362548828)
                    )
                ),
                _City(
                    "Lincoln, NE", "LNK", listOf(
                        _Airport("Lincoln", "LNK", 40.85100173950195, -96.75920104980469)
                    )
                ),
                _City(
                    "Little Rock, AR", "LIT", listOf(
                        _Airport("B. and H. Clinton Natl", "LIT", 34.729400634799994, -92.2242965698)
                    )
                ),
                _City(
                    "Long Beach, CA", "LGB", listOf(
                        _Airport("Long Beach", "LGB", 33.81769943, -118.1520004)
                    )
                ),
                _City(
                    "Los Angeles, CA", "LAX", listOf(
                        _Airport("Los Angeles Intl", "LAX", 33.94250107, -118.4079971)
                    )
                ),
                _City(
                    "Louisville, KY", "SDF", listOf(
                        _Airport("Louisville Intl", "SDF", 38.1744, -85.736)
                    )
                ),
                _City(
                    "Madison, WI", "MSN", listOf(
                        _Airport("Dane County Regional", "MSN", 43.13990020751953, -89.3375015258789)
                    )
                ),
                _City(
                    "Manchester, NH", "MHT", listOf(
                        _Airport("Manchester Boston Regional", "MHT", 42.932598, -71.435699)
                    )
                ),
                _City(
                    "Manhattan, KS", "MHK", listOf(
                        _Airport("Manhattan Regional", "MHK", 39.14099884033203, -96.6707992553711)
                    )
                ),
                _City(
                    "McAllen, TX", "MFE", listOf(
                        _Airport("Miller", "MFE", 26.17580032, -98.23860168)
                    )
                ),
                _City(
                    "Medford, OR", "MFR", listOf(
                        _Airport("Rogue Valley", "MFR", 42.37419891357422, -122.87300109863281)
                    )
                ),
                _City(
                    "Memphis, TN", "MEM", listOf(
                        _Airport("Memphis Intl", "MEM", 35.04240036010742, -89.97669982910156)
                    )
                ),
                _City(
                    "Miami, FL", "MIA", listOf(
                        _Airport("Miami Intl", "MIA", 25.79319953918457, -80.29060363769531)
                    )
                ),
                _City(
                    "Midland / Odessa, TX", "MAF", listOf(
                        _Airport("Midland Intl", "MAF", 31.9424991607666, -102.2020034790039)
                    )
                ),
                _City(
                    "Milwaukee, WI", "MKE", listOf(
                        _Airport("Gen. Mitchell", "MKE", 42.947200775146484, -87.89659881591797)
                    )
                ),
                _City(
                    "Minneapolis / St.Paul, MN", "MSP", listOf(
                        _Airport("St Paul Intl", "MSP", 44.882, -93.221802)
                    )
                ),
                _City(
                    "Minot, ND", "MOT", listOf(
                        _Airport("Minot Intl", "MOT", 48.2593994140625, -101.27999877929688)
                    )
                ),
                _City(
                    "Missoula, MT", "MSO", listOf(
                        _Airport("Missolua Intl", "MSO", 46.91630173, -114.0910034)
                    )
                ),
                _City(
                    "Mobile, AL", "MOB", listOf(
                        _Airport("Mobile Regional", "MOB", 30.691200256348, -88.242797851562)
                    )
                ),
                _City(
                    "Modesto,CA", "MOD", listOf(
                        _Airport("City County", "MOD", 37.62580109, -120.9540024)
                    )
                ),
                _City(
                    "Moline, IL", "MLI", listOf(
                        _Airport("Quad City", "MLI", 41.44850158691406, -90.50749969482422)
                    )
                ),
                _City(
                    "Monroe, LA", "MLU", listOf(
                        _Airport("Monroe Regional", "MLU", 32.51089859008789, -92.0376968383789)
                    )
                ),
                _City(
                    "Monterey / Carmel, CA", "MRY", listOf(
                        _Airport("Monterey Regional", "MRY", 36.58700180053711, -121.84300231933594)
                    )
                ),
                _City(
                    "Montgomery, AL", "MGM", listOf(
                        _Airport("Montgomery Regional", "MGM", 32.30059814, -86.39399719)
                    )
                ),
                _City(
                    "Montrose, CO", "MTJ", listOf(
                        _Airport("Montrose Regional", "MTJ", 38.509799957300004, -107.893997192)
                    )
                ),
                _City(
                    "Muskegon, MI", "MKG", listOf(
                        _Airport("Muskegon County", "MKG", 43.16949844, -86.23819733)
                    )
                ),
                _City(
                    "Myrtle Beach, SC", "MYR", listOf(
                        _Airport("Myrtle Beach Intl", "MYR", 33.6796989441, -78.9282989502)
                    )
                ),
                _City(
                    "Nashville, TN", "BNA", listOf(
                        _Airport("Nashville Intl", "BNA", 36.1245002746582, -86.6781997680664)
                    )
                ),
                _City(
                    "New Orleans, LA", "MSY", listOf(
                        _Airport("Louis Armstrong", "MSY", 29.99340057373047, -90.25800323486328)
                    )
                ),
                _City(
                    "New York, NJ", "NYC", listOf(
                        _Airport("Newark Liberty Intl", "EWR", 40.692501068115234, -74.168701171875)
                    )
                ),
                _City(
                    "Norfolk, VA", "ORF", listOf(
                        _Airport("Norfolk Intl", "ORF", 36.89459991455078, -76.20120239257812)
                    )
                ),
                _City(
                    "North Bend, OR", "OTH", listOf(
                        _Airport("Southwest Oregon Regional", "OTH", 43.41709899902344, -124.24600219726562)
                    )
                ),
                _City(
                    "Oakland, CA", "OAK", listOf(
                        _Airport("Oakland Intl", "OAK", 37.721298, -122.221001)
                    )
                ),
                _City(
                    "Oklahoma City, OK", "OKC", listOf(
                        _Airport("Will Rogers World", "OKC", 35.39310073852539, -97.60070037841797)
                    )
                ),
                _City(
                    "Omaha, NE", "OMA", listOf(
                        _Airport("Eppley Airfield", "OMA", 41.3032, -95.894096)
                    )
                ),
                _City(
                    "Ontario, CA", "ONT", listOf(
                        _Airport("Ontario Intl", "ONT", 34.055999755859375, -117.60099792480469)
                    )
                ),
                _City(
                    "Orlando, FL", "ORL", listOf(
                        _Airport("Orlando Intl", "MCO", 28.429399490356445, -81.30899810791016)
                    )
                ),
                _City(
                    "Palm Springs, CA", "PSP", listOf(
                        _Airport("Palm Springs Intl", "PSP", 33.8297004699707, -116.50700378417969)
                    )
                ),
                _City(
                    "Panama", "ECP", listOf(
                        _Airport("Panama", "ECP", 30.357106, -85.795414)
                    )
                ),
                _City(
                    "Pasco, WA", "PSC", listOf(
                        _Airport("Tri Cities", "PSC", 46.26470184326172, -119.11900329589844)
                    )
                ),
                _City(
                    "Pensacola, FL", "PNS", listOf(
                        _Airport("Pensacola Intl", "PNS", 30.473400115967, -87.186599731445)
                    )
                ),
                _City(
                    "Peoria, IL", "PIA", listOf(
                        _Airport("Gen. W. A. Downing", "PIA", 40.664199829100006, -89.6932983398)
                    )
                ),
                _City(
                    "Philadelphia, PA", "PHL", listOf(
                        _Airport("Philadephia Intl", "PHL", 39.87189865112305, -75.24109649658203)
                    )
                ),
                _City(
                    "Phoenix, AZ", "PHX", listOf(
                        _Airport("Sky Harbour", "PHX", 33.43429946899414, -112.01200103759766)
                    )
                ),
                _City(
                    "Pittsburgh, PA", "PIT", listOf(
                        _Airport("Pittsburgh Intl", "PIT", 40.49150085, -80.23290253)
                    )
                ),
                _City(
                    "Portland, ME", "PWM", listOf(
                        _Airport("Portland Intl Jetport", "PWM", 43.64619827, -70.30930328)
                    )
                ),
                _City(
                    "Portland, OR", "PDX", listOf(
                        _Airport("Portland Intl", "PDX", 45.58869934, -122.5979996)
                    )
                ),
                _City(
                    "Providence, RI", "PVD", listOf(
                        _Airport("T.F.Green", "PVD", 41.732601165771484, -71.42040252685547)
                    )
                ),
                _City(
                    "Raleigh / Durham, NC", "RDU", listOf(
                        _Airport("Raleigh / Durham Intl", "RDU", 35.877601623535156, -78.7874984741211)
                    )
                ),
                _City(
                    "Rapid City, SD", "RAP", listOf(
                        _Airport("Rapid City Regional", "RAP", 44.0452995300293, -103.05699920654297)
                    )
                ),
                _City(
                    "Redding, CA", "RDD", listOf(
                        _Airport("Municipal", "RDD", 40.50899887, -122.2929993)
                    )
                ),
                _City(
                    "Redmond, OR", "RDM", listOf(
                        _Airport("Roberts Field", "RDM", 44.2541008, -121.1500015)
                    )
                ),
                _City(
                    "Reno, NV", "RNO", listOf(
                        _Airport("Tahoe", "RNO", 39.49909973144531, -119.76799774169922)
                    )
                ),
                _City(
                    "Richmond, VA", "RIC", listOf(
                        _Airport("Richmond Intl", "RIC", 37.50519943237305, -77.3197021484375)
                    )
                ),
                _City(
                    "Roanoke, VA", "ROA", listOf(
                        _Airport("Roanoke Regional", "ROA", 37.3255, -79.975403)
                    )
                ),
                _City(
                    "Rochester, NY", "ROC", listOf(
                        _Airport("Greater Rochester", "ROC", 43.118900299072266, -77.67240142822266)
                    )
                ),
                _City(
                    "Rock Springs, WY", "RKS", listOf(
                        _Airport("Sweetwater", "RKS", 41.5942, -109.065001)
                    )
                ),
                _City(
                    "Sacramento, CA", "SAC", listOf(
                        _Airport("Sacramento Intl", "SMF", 38.69540023803711, -121.59100341796875)
                    )
                ),
                _City(
                    "Saginaw, MI", "MBS", listOf(
                        _Airport("MBS Intl", "MBS", 43.532901763916016, -84.07959747314453)
                    )
                ),
                _City(
                    "Salt Lake City, UT", "SLC", listOf(
                        _Airport("Salt Lake City Intl", "SLC", 40.78839874267578, -111.97799682617188)
                    )
                ),
                _City(
                    "San Antonio, TX", "SAT", listOf(
                        _Airport("San Antonio Intl", "SAT", 29.533700942993164, -98.46980285644531)
                    )
                ),
                _City(
                    "San Diego, CA", "SAN", listOf(
                        _Airport("San Diego Intl", "SAN", 32.7336006165, -117.190002441)
                    )
                ),
                _City(
                    "San Francisco, CA", "SFO", listOf(
                        _Airport("San Francisco Intl", "SFO", 37.61899948120117, -122.375)
                    )
                ),
                _City(
                    "San Jose, CA", "SJC", listOf(
                        _Airport("Norman Y. Mineta", "SJC", 37.362598, -121.929001)
                    )
                ),
                _City(
                    "San Luis Obispo, CA", "CSL", listOf(
                        _Airport("San Luis County Regional", "SBP", 35.236801147499996, -120.641998291)
                    )
                ),
                _City(
                    "Santa Ana, CA", "SNA", listOf(
                        _Airport("J. Wayne Orange County", "SNA", 33.67570114, -117.8679962)
                    )
                ),
                _City(
                    "Santa Barbara, CA", "SBA", listOf(
                        _Airport("Santa Barbara Municipal", "SBA", 34.42620087, -119.8399963)
                    )
                ),
                _City(
                    "Santa Fe, NM", "SAF", listOf(
                        _Airport("Santa Fe Municipal", "SAF", 35.617099762, -106.088996887)
                    )
                ),
                _City(
                    "Santa Maria, CA", "SMX", listOf(
                        _Airport("Public Apt", "SMX", 34.89889908, -120.4570007)
                    )
                ),
                _City(
                    "Sarasota  / Bradenton, FL", "SRQ", listOf(
                        _Airport("Sarasota / Bradenton Intl", "SRQ", 27.39539909362793, -82.55439758300781)
                    )
                ),
                _City(
                    "Savannah, GA", "SAV", listOf(
                        _Airport("Hilton Head", "SAV", 32.12760162, -81.20210266)
                    )
                ),
                _City(
                    "Seattle, WA", "SEA", listOf(
                        _Airport("Tacoma", "SEA", 47.449001, -122.308998)
                    )
                ),
                _City(
                    "Shreveport, LA", "SHV", listOf(
                        _Airport("Shreveport Regional", "SHV", 32.446602, -93.8256)
                    )
                ),
                _City(
                    "Sioux Falls, SD", "FSD", listOf(
                        _Airport("Sioux Falls Regional", "FSD", 43.582000732400004, -96.741897583)
                    )
                ),
                _City(
                    "South Bend, IN", "SBN", listOf(
                        _Airport("South Bend Intl", "SBN", 41.70869827270508, -86.31729888916016)
                    )
                ),
                _City(
                    "Spokane, WA", "GEG", listOf(
                        _Airport("Spokane Intl", "GEG", 47.61989974975586, -117.53399658203125)
                    )
                ),
                _City(
                    "Springfield, MO", "SGF", listOf(
                        _Airport("Branson National", "SGF", 37.24570084, -93.38860321)
                    )
                ),
                _City(
                    "State College, PA", "SCE", listOf(
                        _Airport("University Park", "SCE", 40.8493003845, -77.84870147710001)
                    )
                ),
                _City(
                    "Saint George, UT", "SGU", listOf(
                        _Airport("Saint George Municipal", "SGU", 37.036389, -113.510306)
                    )
                ),
                _City(
                    "Saint Louis, MO", "STL", listOf(
                        _Airport("Lambert", "STL", 38.748697, -90.370003)
                    )
                ),
                _City(
                    "Saint Thomas", "STT", listOf(
                        _Airport("St Thomas Island", "STT", 18.337299346923828, -64.97339630126953)
                    )
                ),
                _City(
                    "Syracuse, NY", "SYR", listOf(
                        _Airport("Hancock", "SYR", 43.11119842529297, -76.1063003540039)
                    )
                ),
                _City(
                    "Tallahassee, FL", "TLH", listOf(
                        _Airport("Tallahassee Intl", "TLH", 30.396499633789062, -84.35030364990234)
                    )
                ),
                _City(
                    "Tampa, FL", "TPA", listOf(
                        _Airport("Tampa Intl", "TPA", 27.975500106811523, -82.533203125)
                    )
                ),
                _City(
                    "Toledo, OH", "TOL", listOf(
                        _Airport("Toledo Express", "TOL", 41.58679962, -83.80780029)
                    )
                ),
                _City(
                    "Traverse City, MI", "TVC", listOf(
                        _Airport("Cherry Capital", "TVC", 44.74140167236328, -85.58219909667969)
                    )
                ),
                _City(
                    "Tucson, AZ", "TUS", listOf(
                        _Airport("Tucson Intl", "TUS", 32.1161003112793, -110.94100189208984)
                    )
                ),
                _City(
                    "Tulsa, OK", "TUL", listOf(
                        _Airport("Tulsa Intl", "TUL", 36.19839859008789, -95.88809967041016)
                    )
                ),
                _City(
                    "Vail Eagle, CO", "EGE", listOf(
                        _Airport("Eagle County Regional", "EGE", 39.64260101, -106.9179993)
                    )
                ),
                _City(
                    "Valparaiso, FL", "VPS", listOf(
                        _Airport("Destin–Fort Walton Beach", "VPS", 30.4832, -86.525398)
                    )
                ),
                _City(
                    "Waco, TX", "ACT", listOf(
                        _Airport("Waco Regional", "ACT", 31.611299514770508, -97.23049926757812)
                    )
                ),
                _City(
                    "Walla Walla, WA", "ALW", listOf(
                        _Airport("Walla walla Regional", "ALW", 46.09489822, -118.288002)
                    )
                ),
                _City(
                    "Washington, DC", "WAS", listOf(
                        _Airport("Dulles", "IAD", 38.94449997, -77.45580292),
                        _Airport("Ronald Reagan National", "DCA", 38.8521, -77.037697)
                    )
                ),
                _City(
                    "Wausau, WI", "AUW", listOf(
                        _Airport("Central Wisconsin", "CWA", 44.7775993347, -89.6668014526)
                    )
                ),
                _City(
                    "White Plains, NY", "HPN", listOf(
                        _Airport("Westchester County", "HPN", 41.06700134277344, -73.70760345458984)
                    )
                ),
                _City(
                    "West Palm Beach, FL", "PBI", listOf(
                        _Airport("Palm Beach Intl", "PBI", 26.68320083618164, -80.09559631347656)
                    )
                ),
                _City(
                    "Wichita, KS", "ICT", listOf(
                        _Airport("D. D. Eisenhower Natl", "ICT", 37.649899, -97.433098)
                    )
                ),
                _City(
                    "Wilkes-Barre / Scranton, PA", "AVP", listOf(
                        _Airport("Wilkes-Barre / Scranton Intl", "AVP", 41.338500976599995, -75.72339630130001)
                    )
                ),
                _City(
                    "Wilmington, NC", "ILM", listOf(
                        _Airport("Wilmington Intl", "ILM", 34.270599365234375, -77.90260314941406)
                    )
                ),
                _City(
                    "Yakima, WA", "YKM", listOf(
                        _Airport("Air Terminal", "YKM", 46.56819916, -120.5439987)
                    )
                )
            )
        ),
        _Country(
            "Cambodia", "KH", listOf(
                _City(
                    "Phnom Penh", "PNH", listOf(
                        _Airport("Phnom Penh Intl", "PNH", 11.546600341796875, 104.84400177001953)
                    )
                )
            )
        ),
        _Country(
            "China", "CN", listOf(
                _City(
                    "Changchun", "CGQ", listOf(
                        _Airport("Longjia", "CGQ", 43.9962005615, 125.684997559)
                    )
                ),
                _City(
                    "Changsha", "CSX", listOf(
                        _Airport("Huanghua", "CSX", 28.189199447599997, 113.220001221)
                    )
                ),
                _City(
                    "Chengdu", "CTU", listOf(
                        _Airport("Shuangliu", "CTU", 30.578500747680664, 103.9469985961914)
                    )
                ),
                _City(
                    "Chongqing", "CKG", listOf(
                        _Airport("Jiangbei", "CKG", 29.719200134277344, 106.64199829101562)
                    )
                ),
                _City(
                    "Beijing", "BJS", listOf(
                        _Airport("Capital", "PEK", 40.080101013183594, 116.58499908447266)
                    )
                ),
                _City(
                    "Dalian", "DLC", listOf(
                        _Airport("Zhoushuizi", "DLC", 38.9656982421875, 121.53900146484375)
                    )
                ),
                _City(
                    "Fuzhou", "FOC", listOf(
                        _Airport("Changle", "FOC", 25.935100555419922, 119.66300201416016)
                    )
                ),
                _City(
                    "Guangzhou", "CAN", listOf(
                        _Airport("Baiyun", "CAN", 23.39240074157715, 113.29900360107422)
                    )
                ),
                _City(
                    "Guilin", "KWL", listOf(
                        _Airport("Liangjiang", "KWL", 25.21809959411621, 110.03900146484375)
                    )
                ),
                _City(
                    "Haikou", "HAK", listOf(
                        _Airport("Meilan", "HAK", 19.934900283813477, 110.45899963378906)
                    )
                ),
                _City(
                    "Hangzhou", "HGH", listOf(
                        _Airport("Xiaoshan", "HGH", 30.22949981689453, 120.43399810791016)
                    )
                ),
                _City(
                    "Harbin", "HRB", listOf(
                        _Airport("Taiping", "HRB", 45.6234016418457, 126.25)
                    )
                ),
                _City(
                    "Hefei", "HFE", listOf(
                        _Airport("Xinqiao", "HFE", 31.780000686645508, 117.2979965209961)
                    )
                ),
                _City(
                    "Hohhot", "HET", listOf(
                        _Airport("Baita", "HET", 40.851398, 111.823997)
                    )
                ),
                _City(
                    "Hong Kong", "HKG", listOf(
                        _Airport("Hong Kong Intl", "HKG", 22.308901, 113.915001)
                    )
                ),
                _City(
                    "Jinan", "TNA", listOf(
                        _Airport("Yaoqiang", "TNA", 36.857200622558594, 117.21600341796875)
                    )
                ),
                _City(
                    "Kunming", "KMG", listOf(
                        _Airport("Changshui", "KMG", 25.1019444, 102.9291667)
                    )
                ),
                _City(
                    "Lanzhou", "LHW", listOf(
                        _Airport("Zhongchuan ", "LHW", 36.5152015686, 103.620002747)
                    )
                ),
                _City(
                    "Mianyang", "MIG", listOf(
                        _Airport("Nanjiao", "MIG", 31.4281005859375, 104.74099731445312)
                    )
                ),
                _City(
                    "Nanchang", "KHN", listOf(
                        _Airport("Changbei", "KHN", 28.864999771118164, 115.9000015258789)
                    )
                ),
                _City(
                    "Nanjing", "NKG", listOf(
                        _Airport("Lukou", "NKG", 31.742000579833984, 118.86199951171875)
                    )
                ),
                _City(
                    "Nanning", "NNG", listOf(
                        _Airport("Wuxu", "NNG", 22.608299255371094, 108.1719970703125)
                    )
                ),
                _City(
                    "Qingdao", "TAO", listOf(
                        _Airport("Liuting", "TAO", 36.2661018372, 120.374000549)
                    )
                ),
                _City(
                    "Sanya", "SYX", listOf(
                        _Airport("Phoenix", "SYX", 18.302900314331055, 109.41200256347656)
                    )
                ),
                _City(
                    "Shanghai", "SHA", listOf(
                        _Airport("Hongqiao", "SHA", 31.197900772094727, 121.33599853515625),
                        _Airport("Pudong ", "PVG", 31.143400192260742, 121.80500030517578)
                    )
                ),
                _City(
                    "Shenyang", "SHE", listOf(
                        _Airport("Taoxian", "SHE", 41.639801025390625, 123.48300170898438)
                    )
                ),
                _City(
                    "Shenzhen", "SZX", listOf(
                        _Airport("Bao An", "SZX", 22.639299392700195, 113.81099700927734)
                    )
                ),
                _City(
                    "Taiyuan", "TYN", listOf(
                        _Airport("Wusu", "TYN", 37.74689865112305, 112.62799835205078)
                    )
                ),
                _City(
                    "Wenzhou", "WNZ", listOf(
                        _Airport("Yongqiang", "WNZ", 27.912201, 120.851997)
                    )
                ),
                _City(
                    "Wuhan", "WUH", listOf(
                        _Airport("Tianhe", "WUH", 30.7838, 114.208)
                    )
                ),
                _City(
                    "Wuxi", "WUX", listOf(
                        _Airport("Sunan Shuofang", "WUX", 31.494400024399997, 120.429000854)
                    )
                ),
                _City(
                    "Xiamen", "XMN", listOf(
                        _Airport("Gaoqi", "XMN", 24.54400062561035, 118.12799835205078)
                    )
                ),
                _City(
                    "Xi an", "SIA", listOf(
                        _Airport("Xianyang", "XIY", 34.447102, 108.751999)
                    )
                ),
                _City(
                    "Yantai", "YNT", listOf(
                        _Airport("Penglai", "YNT", 37.40169906616211, 121.37200164794922)
                    )
                ),
                _City(
                    "Zhengzhou", "CGO", listOf(
                        _Airport("Xinzheng", "CGO", 34.519699096699995, 113.841003418)
                    )
                ),
                _City(
                    "Zhuhai", "ZUH", listOf(
                        _Airport("Sanzao", "ZUH", 22.006399, 113.375999)
                    )
                )
            )
        ),
        _Country(
            "Cyprus", "CY", listOf(
                _City(
                    "Larnaca Cyprys", "LCA", listOf(
                        _Airport("Larnaca", "LCA", 34.875099182128906, 33.624900817871094)
                    )
                )
            )
        ),
        _Country(
            "India", "IN", listOf(
                _City(
                    "Bengaluru", "BLR", listOf(
                        _Airport("Kempegowda", "BLR", 13.1979, 77.706299)
                    )
                ),
                _City(
                    "Chennai", "MAA", listOf(
                        _Airport("Chennai Intl", "MAA", 12.990005493164062, 80.16929626464844)
                    )
                ),
                _City(
                    "Coimbatore", "CBE", listOf(
                        _Airport("Coimbatore Airport", "CBJ", 17.929000854492188, -71.6447982788086)
                    )
                ),
                _City(
                    "Delhi", "DEL", listOf(
                        _Airport("Indira Gandhi", "DEL", 28.5665, 77.103104)
                    )
                ),
                _City(
                    "Mumbai", "BOM", listOf(
                        _Airport("Chhatrapati Shijavi", "BOM", 19.0886993408, 72.8678970337)
                    )
                )
            )
        ),
        _Country(
            "Indonesia", "ID", listOf(
                _City(
                    "Denpasar Bali", "DPS", listOf(
                        _Airport("Ngurah Rai", "DPS", -8.7481698989868, 115.16699981689)
                    )
                ),
                _City(
                    "Jakarta", "JKT", listOf(
                        _Airport("Soekarno Hatta", "CGK", -6.1255698204, 106.65599823)
                    )
                )
            )
        ),
        _Country(
            "Japan", "JP", listOf(
                _City(
                    "Fukuoka", "FUK", listOf(
                        _Airport("Fukuoka", "FUK", 33.585899353027344, 130.4510040283203)
                    )
                ),
                _City(
                    "Hakodate", "HKD", listOf(
                        _Airport("Hakodate", "HKD", 41.7700004578, 140.822006226)
                    )
                ),
                _City(
                    "Hiroshima", "HIJ", listOf(
                        _Airport("Hiroshima", "HIJ", 34.4361000061, 132.919006348)
                    )
                ),
                _City(
                    "Kagoshima", "KOJ", listOf(
                        _Airport("Kagoshima", "KOJ", 31.80340003967285, 130.718994140625)
                    )
                ),
                _City(
                    "Komatsu", "KMQ", listOf(
                        _Airport("Komatsu", "KMQ", 36.39459991455078, 136.40699768066406)
                    )
                ),
                _City(
                    "Nagoya", "NGO", listOf(
                        _Airport("Chubu Centrair", "NGO", 34.8583984375, 136.80499267578125)
                    )
                ),
                _City(
                    "Okayama", "OKJ", listOf(
                        _Airport("Okayama", "OKJ", 34.7569007874, 133.854995728)
                    )
                ),
                _City(
                    "Okinawa", "OKA", listOf(
                        _Airport("Naha", "OKA", 26.1958007812, 127.646003723)
                    )
                ),
                _City(
                    "Osaka", "OSA", listOf(
                        _Airport("Itami", "ITM", 34.785499572753906, 135.43800354003906),
                        _Airport("Kansai", "KIX", 34.42729949951172, 135.24400329589844)
                    )
                ),
                _City(
                    "Sapporo", "SPK", listOf(
                        _Airport("New Chitose", "CTS", 42.77519989013672, 141.69200134277344),
                        _Airport("Sapporo Okadama", "OKD", 43.117447, 141.38134)
                    )
                ),
                _City(
                    "Sendai", "SDJ", listOf(
                        _Airport("Sendai", "SDJ", 38.1397018433, 140.917007446)
                    )
                ),
                _City(
                    "Tokyo", "TYO", listOf(
                        _Airport("Haneda", "HND", 35.552299, 139.779999),
                        _Airport("Narita", "NRT", 35.7647018433, 140.386001587)
                    )
                ),
                _City(
                    "Toyama", "TOY", listOf(
                        _Airport("Toyama", "TOY", 36.64830017089844, 137.18800354003906)
                    )
                )
            )
        ),
        _Country(
            "Korea", "KR", listOf(
                _City(
                    "Busan", "PUS", listOf(
                        _Airport("Gimhae", "PUS", 35.1795005798, 128.93800354)
                    )
                ),
                _City(
                    "Seoul", "SEL", listOf(
                        _Airport("Gimpo", "GMP", 37.5583, 126.791),
                        _Airport("Incheon", "ICN", 37.46910095214844, 126.45099639892578)
                    )
                )
            )
        ),
        _Country(
            "Malaysia", "MY", listOf(
                _City(
                    "Kuala Lumpur", "KUL", listOf(
                        _Airport("Kuala Lumpur", "KUL", 2.745579957962, 101.70999908447)
                    )
                )
            )
        ),
        _Country(
            "Philippines", "PH", listOf(
                _City(
                    "Manila", "MNL", listOf(
                        _Airport("Ninoy Aquino", "MNL", 14.5086, 121.019997)
                    )
                )
            )
        ),
        _Country(
            "Singapore", "SG", listOf(
                _City(
                    "Singapore", "SIN", listOf(
                        _Airport("Singapore Changi", "SIN", 1.35019, 103.994003)
                    )
                )
            )
        ),
        _Country(
            "Taiwan, China", "TW", listOf(
                _City(
                    "Kaohsiung", "KHH", listOf(
                        _Airport("Kaohsiung Intl", "KHH", 22.57710075378418, 120.3499984741211)
                    )
                ),
                _City(
                    "Taipei", "TPE", listOf(
                        _Airport("Taoyuan", "TPE", 25.0777, 121.233002),
                        _Airport("Songshan", "TSA", 25.069400787353516, 121.552001953125)
                    )
                )
            )
        ),
        _Country(
            "Thailand", "TH", listOf(
                _City(
                    "Bangkok", "BKK", listOf(
                        _Airport("Suvarnabhumi", "BKK", 13.681099891662598, 100.74700164794922)
                    )
                ),
                _City(
                    "Chiang Mai", "CNX", listOf(
                        _Airport("Chiang Mai", "CNX", 18.766799926799997, 98.962600708)
                    )
                ),
                _City(
                    "Krabi", "KBV", listOf(
                        _Airport("Krabi", "KBV", 8.09912014008, 98.9861984253)
                    )
                ),
                _City(
                    "Phuket", "HKT", listOf(
                        _Airport("Phuket Intl", "HKT", 8.1132, 98.316902)
                    )
                )
            )
        ),
        _Country(
            "Vietnam", "VN", listOf(
                _City(
                    "Da Nang", "DAD", listOf(
                        _Airport("Da Nang", "DAD", 16.043899536132812, 108.1989974975586)
                    )
                ),
                _City(
                    "Hanoi", "HAN", listOf(
                        _Airport("No Bai", "HAN", 21.221200942993164, 105.80699920654297)
                    )
                ),
                _City(
                    "Ho Chi Minh City", "SGN", listOf(
                        _Airport("Tan Son Nhat", "SGN", 10.8187999725, 106.652000427)
                    )
                )
            )
        ),
        _Country(
            "Albania", "AL", listOf(
                _City(
                    "Tirana", "TIA", listOf(
                        _Airport("Nene Tereza", "TIA", 41.4146995544, 19.7206001282)
                    )
                )
            )
        ),
        _Country(
            "Austria", "AT", listOf(
                _City(
                    "Graz", "GRZ", listOf(
                        _Airport("Graz", "GRZ", 46.9911003112793, 15.439599990844727)
                    )
                ),
                _City(
                    "Innsbruck", "INN", listOf(
                        _Airport("Innsbruck", "INN", 47.260201, 11.344)
                    )
                ),
                _City(
                    "Linz", "LNZ", listOf(
                        _Airport("Blue Danube", "LNZ", 48.2332, 14.1875)
                    )
                ),
                _City(
                    "Salzburg", "SZG", listOf(
                        _Airport("W. A. Mozart", "SZG", 47.793300628699996, 13.0043001175)
                    )
                ),
                _City(
                    "Vienna", "VIE", listOf(
                        _Airport("Vienna Intl", "VIE", 48.110298156738, 16.569700241089)
                    )
                )
            )
        ),
        _Country(
            "Belgium", "BE", listOf(
                _City(
                    "Brussels", "BRU", listOf(
                        _Airport("Brussels", "BRU", 50.901401519800004, 4.48443984985)
                    )
                )
            )
        ),
        _Country(
            "Bosnia Herzegovina", "BA", listOf(
                _City(
                    "Sarajevo", "SJJ", listOf(
                        _Airport("Sarajevo Intl", "SJJ", 43.82460021972656, 18.331499099731445)
                    )
                )
            )
        ),
        _Country(
            "Bulgaria", "BG", listOf(
                _City(
                    "Sofia", "SOF", listOf(
                        _Airport("Sofia", "SOF", 42.696693420410156, 23.411436080932617)
                    )
                )
            )
        ),
        _Country(
            "Croatia", "HR", listOf(
                _City(
                    "Dubrovnik", "DBV", listOf(
                        _Airport("Dubrovnik", "DBV", 42.5614013671875, 18.268199920654297)
                    )
                ),
                _City(
                    "Pula", "PUY", listOf(
                        _Airport("Pula", "PUY", 44.89350128173828, 13.922200202941895)
                    )
                ),
                _City(
                    "Split", "SPU", listOf(
                        _Airport("Split", "SPU", 43.53889846801758, 16.29800033569336)
                    )
                ),
                _City(
                    "Zagreb", "ZAG", listOf(
                        _Airport("Pleso", "ZAG", 45.7429008484, 16.0687999725)
                    )
                )
            )
        ),
        _Country(
            "Czech Republic", "CZ", listOf(
                _City(
                    "Prague", "PRG", listOf(
                        _Airport("Ruzyne", "PRG", 50.1008, 14.26)
                    )
                )
            )
        ),
        _Country(
            "Denmark", "DK", listOf(
                _City(
                    "Aalborg", "AAL", listOf(
                        _Airport("Aalborg", "AAL", 57.0927589138, 9.84924316406)
                    )
                ),
                _City(
                    "Aarhus", "AAR", listOf(
                        _Airport("Aarhus", "AAR", 56.2999992371, 10.619000434899998)
                    )
                ),
                _City(
                    "Billund", "BLL", listOf(
                        _Airport("Billund", "BLL", 55.7402992249, 9.15178012848)
                    )
                ),
                _City(
                    "Bornholm", "RNN", listOf(
                        _Airport("Ronne", "RNN", 55.06330108642578, 14.759599685668945)
                    )
                ),
                _City(
                    "Copenhagen", "CPH", listOf(
                        _Airport("Kastrup", "CPH", 55.617900848389, 12.656000137329)
                    )
                ),
                _City(
                    "Karup", "KRP", listOf(
                        _Airport("Karup", "KRP", 56.29750061035156, 9.124629974365234)
                    )
                ),
                _City(
                    "Sonderborg", "SGD", listOf(
                        _Airport("Sønderborg", "SGD", 54.96440124511719, 9.791729927062988)
                    )
                )
            )
        ),
        _Country(
            "Estonia", "EE", listOf(
                _City(
                    "Tallinn", "TLL", listOf(
                        _Airport("Lennart Meri", "TLL", 59.41329956049999, 24.832799911499997)
                    )
                )
            )
        ),
        _Country(
            "Faroe Islands", "FO", listOf(
                _City(
                    "Faroe Islands", "FAE", listOf(
                        _Airport("Vagar", "FAE", 62.0635986328125, -7.277219772338867)
                    )
                )
            )
        ),
        _Country(
            "Finland", "FI", listOf(
                _City(
                    "Helsinki", "HEL", listOf(
                        _Airport("Vantaa", "HEL", 60.317199707031, 24.963300704956)
                    )
                ),
                _City(
                    "Oulu", "OUL", listOf(
                        _Airport("Oulu", "OUL", 64.930099487305, 25.354600906372)
                    )
                ),
                _City(
                    "Tampere", "TMP", listOf(
                        _Airport("Pirkkala", "TMP", 61.414100646973, 23.604400634766)
                    )
                ),
                _City(
                    "Turku", "TKU", listOf(
                        _Airport("Turku", "TKU", 60.514099121094, 22.262800216675)
                    )
                ),
                _City(
                    "Vaasa", "VAA", listOf(
                        _Airport("Vaasa", "VAA", 63.050701141357, 21.762199401855)
                    )
                )
            )
        ),
        _Country(
            "France", "FR", listOf(
                _City(
                    "Biarritz", "BIQ", listOf(
                        _Airport("Pays Basque", "BIQ", 43.4683333, -1.5311111)
                    )
                ),
                _City(
                    "Lyon", "LYS", listOf(
                        _Airport("Saint Exupery", "LYS", 45.725556, 5.081111)
                    )
                ),
                _City(
                    "Marseille", "MRS", listOf(
                        _Airport("Provence", "MRS", 43.439271922, 5.22142410278)
                    )
                ),
                _City(
                    "Montpellier", "MPL", listOf(
                        _Airport("Mediterranee", "MPL", 43.57619857788086, 3.96301007270813)
                    )
                ),
                _City(
                    "Nice", "NCE", listOf(
                        _Airport("Cote d Azur", "NCE", 43.6584014893, 7.215869903560001)
                    )
                ),
                _City(
                    "Paris", "PAR", listOf(
                        _Airport("Charles De Gaulle", "CDG", 49.012798, 2.55)
                    )
                ),
                _City(
                    "Toulouse", "TLS", listOf(
                        _Airport("Blagnac", "TLS", 43.629101, 1.36382)
                    )
                )
            )
        ),
        _Country(
            "Germany", "DE", listOf(
                _City(
                    "Berlin", "BER", listOf(
                        _Airport("Tegel - Otto Lilienthal", "TXL", 52.5597, 13.2877)
                    )
                ),
                _City(
                    "Dresden", "DRS", listOf(
                        _Airport("Dresden Intl", "DRS", 51.1328010559082, 13.767200469970703)
                    )
                ),
                _City(
                    "Dusseldorf", "DUS", listOf(
                        _Airport("Düsseldorf", "DUS", 51.289501, 6.76678)
                    )
                ),
                _City(
                    "Frankfurt", "FRA", listOf(
                        _Airport("Frankfurt", "FRA", 50.033333, 8.570556)
                    )
                ),
                _City(
                    "Friedrichshafen", "FDH", listOf(
                        _Airport("Bodensee", "FDH", 47.671298980699994, 9.51148986816)
                    )
                ),
                _City(
                    "Hamburg", "HAM", listOf(
                        _Airport("Helmut Schmidt", "HAM", 53.630401611328, 9.9882297515869)
                    )
                ),
                _City(
                    "Hanover", "HAJ", listOf(
                        _Airport("Langenhagen", "HAJ", 52.461101532, 9.685079574580001)
                    )
                ),
                _City(
                    "Leipzig / Halle", "LEJ", listOf(
                        _Airport("Leipzig / Halle", "LEJ", 51.423889, 12.236389)
                    )
                ),
                _City(
                    "Munich", "MUC", listOf(
                        _Airport("Franz Josef Strauss", "MUC", 48.353802, 11.7861)
                    )
                ),
                _City(
                    "Münster / Osnabrück", "FMO", listOf(
                        _Airport("Münster / Osnabrück Intl", "FMO", 52.134601593, 7.68483018875)
                    )
                ),
                _City(
                    "Nuremberg", "NUE", listOf(
                        _Airport("Albrecht Durer", "NUE", 49.498699, 11.078056)
                    )
                ),
                _City(
                    "Stuttgart", "STR", listOf(
                        _Airport("Manfred Rommel", "STR", 48.689899444599995, 9.22196006775)
                    )
                )
            )
        ),
        _Country(
            "Greece", "GR", listOf(
                _City(
                    "Alexandroupolis", "AXD", listOf(
                        _Airport("Dimokritos", "AXD", 40.855899810791016, 25.956300735473633)
                    )
                ),
                _City(
                    "Athens", "ATH", listOf(
                        _Airport("E. Venizelos", "ATH", 37.9364013672, 23.9444999695)
                    )
                ),
                _City(
                    "Chania Crete", "CHQ", listOf(
                        _Airport("I. Daskalogiannis", "CHQ", 35.531700134277344, 24.149700164794922)
                    )
                ),
                _City(
                    "Chios", "JKH", listOf(
                        _Airport("National Omiros", "JKH", 38.34320068359375, 26.140600204467773)
                    )
                ),
                _City(
                    "Heraklion Crete", "HER", listOf(
                        _Airport("Nikos Kazantzakis", "HER", 35.3396987915, 25.180299758900002)
                    )
                ),
                _City(
                    "Ioannina", "IOA", listOf(
                        _Airport("National King Pyrrhus", "IOA", 39.6963996887207, 20.822500228881836)
                    )
                ),
                _City(
                    "Kavala", "KVA", listOf(
                        _Airport("Megas Alexandros", "KVA", 40.913299560546875, 24.619199752807617)
                    )
                ),
                _City(
                    "Kefallinia", "EFL", listOf(
                        _Airport("Anna Pollatou", "EFL", 38.12009811401367, 20.500499725341797)
                    )
                ),
                _City(
                    "Kerkyra Corfu", "CFU", listOf(
                        _Airport("Ioannis Kapodistrias", "CFU", 39.601898193359375, 19.911699295043945)
                    )
                ),
                _City(
                    "Kos", "KGS", listOf(
                        _Airport("Ippokratis", "KGS", 36.79330062866211, 27.091699600219727)
                    )
                ),
                _City(
                    "Limnos", "LXS", listOf(
                        _Airport("Hephaestus", "LXS", 39.917098999, 25.236299514799995)
                    )
                ),
                _City(
                    "Mykonos", "JMK", listOf(
                        _Airport("National Dilos", "JMK", 37.43510055541992, 25.348100662231445)
                    )
                ),
                _City(
                    "Mytilene Lesbos", "MJT", listOf(
                        _Airport("Odysseas Elitis", "MJT", 39.0567016602, 26.5983009338)
                    )
                ),
                _City(
                    "Rhodes", "RHO", listOf(
                        _Airport("Diagoras", "RHO", 36.405399322509766, 28.086200714111328)
                    )
                ),
                _City(
                    "Samos", "SMI", listOf(
                        _Airport("Aristarchos", "SMI", 37.689998626708984, 26.911699295043945)
                    )
                ),
                _City(
                    "Thessaloniki", "SKG", listOf(
                        _Airport("Macedonia", "SKG", 40.51969909667969, 22.97089958190918)
                    )
                ),
                _City(
                    "Thira Santorini", "JTR", listOf(
                        _Airport("National Zefiros", "JTR", 36.399200439453125, 25.479299545288086)
                    )
                )
            )
        ),
        _Country(
            "Hungary", "HU", listOf(
                _City(
                    "Budapest", "BUD", listOf(
                        _Airport("Ferenc Liszt ", "BUD", 47.42976, 19.261093)
                    )
                )
            )
        ),
        _Country(
            "Iceland", "IS", listOf(
                _City(
                    "Reykjavik", "REK", listOf(
                        _Airport("Keflavik", "KEF", 63.985000610352, -22.605600357056)
                    )
                )
            )
        ),
        _Country(
            "Ireland", "IE", listOf(
                _City(
                    "Cork", "ORK", listOf(
                        _Airport("Cork", "ORK", 51.84130096435547, -8.491109848022461)
                    )
                ),
                _City(
                    "Dublin", "DUB", listOf(
                        _Airport("Dublin", "DUB", 53.421299, -6.27007)
                    )
                ),
                _City(
                    "Knock", "NOC", listOf(
                        _Airport("Ireland West", "NOC", 53.910301208496094, -8.818490028381348)
                    )
                ),
                _City(
                    "Shannon", "SNN", listOf(
                        _Airport("Shannon", "SNN", 52.701999664307, -8.9248199462891)
                    )
                )
            )
        ),
        _Country(
            "Italy", "IT", listOf(
                _City(
                    "Ancona", "AOI", listOf(
                        _Airport("Marche", "AOI", 43.616299, 13.3623)
                    )
                ),
                _City(
                    "Bologna", "BLQ", listOf(
                        _Airport("Guglielmo Marconi", "BLQ", 44.5354, 11.2887)
                    )
                ),
                _City(
                    "Cagliari Sardinia", "CAG", listOf(
                        _Airport("Elmas Intl M. Mameli", "CAG", 39.251499, 9.05428)
                    )
                ),
                _City(
                    "Catania, Sicilien", "CTA", listOf(
                        _Airport("Fontanarossa Intl V. Bellini", "CTA", 37.466801, 15.0664)
                    )
                ),
                _City(
                    "Florence", "FLR", listOf(
                        _Airport("Peretola", "FLR", 43.810001, 11.2051)
                    )
                ),
                _City(
                    "Genoa", "GOA", listOf(
                        _Airport("Colombo", "GOA", 44.4133, 8.8375)
                    )
                ),
                _City(
                    "Milan", "MIL", listOf(
                        _Airport("Linate", "LIN", 45.445099, 9.27674),
                        _Airport("Malpensa", "MXP", 45.6306, 8.72811)
                    )
                ),
                _City(
                    "Naples", "NAP", listOf(
                        _Airport("Capodichino", "NAP", 40.886002, 14.2908)
                    )
                ),
                _City(
                    "Olbia Sardinia", "OLB", listOf(
                        _Airport("Costa Smeralda", "OLB", 40.898701, 9.51763)
                    )
                ),
                _City(
                    "Palermo Sicily", "PMO", listOf(
                        _Airport("Falcone–Borsellino", "PMO", 38.175999, 13.091)
                    )
                ),
                _City(
                    "Pisa", "PSA", listOf(
                        _Airport("Galileo Galilei", "PSA", 43.683899, 10.3927)
                    )
                ),
                _City(
                    "Rome", "ROM", listOf(
                        _Airport("Leonardo da Vinci - Fiumicino", "FCO", 41.8002778, 12.2388889)
                    )
                ),
                _City(
                    "Trieste", "TRS", listOf(
                        _Airport("Friuli Venezia Giulia", "TRS", 45.827499, 13.4722)
                    )
                ),
                _City(
                    "Turin", "TRN", listOf(
                        _Airport("Caselle Sandro Pertini", "TRN", 45.200802, 7.64963)
                    )
                ),
                _City(
                    "Venice", "VCE", listOf(
                        _Airport("Marco Polo", "VCE", 45.505299, 12.3519)
                    )
                ),
                _City(
                    "Verona", "VRN", listOf(
                        _Airport("Villafranca V. Catullo", "VRN", 45.395699, 10.8885)
                    )
                )
            )
        ),
        _Country(
            "Kosovo", "XK", listOf(
                _City(
                    "Pristina", "PRN", listOf(
                        _Airport("Adem Jashari", "PRN", 42.5728, 21.035801)
                    )
                )
            )
        ),
        _Country(
            "Latvia", "LV", listOf(
                _City(
                    "Riga", "RIX", listOf(
                        _Airport("Riga Intl", "RIX", 56.92359924316406, 23.971099853515625)
                    )
                )
            )
        ),
        _Country(
            "Lebanon", "LB", listOf(
                _City(
                    "Beirut", "BEY", listOf(
                        _Airport("Rafic Hariri", "BEY", 33.820899963378906, 35.488399505615234)
                    )
                )
            )
        ),
        _Country(
            "Lithuania", "LT", listOf(
                _City(
                    "Palanga / Klaipeda", "PLQ", listOf(
                        _Airport("Palanga / Klaipeda Intl", "PLQ", 55.973201751708984, 21.093900680541992)
                    )
                ),
                _City(
                    "Vilnius", "VNO", listOf(
                        _Airport("Vilnius Intl", "VNO", 54.634102, 25.285801)
                    )
                )
            )
        ),
        _Country(
            "Luxembourg", "LU", listOf(
                _City(
                    "Luxembourg", "LUX", listOf(
                        _Airport("Luxembourg", "LUX", 49.6233333, 6.2044444)
                    )
                )
            )
        ),
        _Country(
            "Republic Of Macedonia", "MK", listOf(
                _City(
                    "Skopje", "SKP", listOf(
                        _Airport("Alexander the Great", "SKP", 41.961601, 21.621401)
                    )
                )
            )
        ),
        _Country(
            "Malta", "MT", listOf(
                _City(
                    "Malta", "MLA", listOf(
                        _Airport("Malta Intl", "MLA", 35.857498, 14.4775)
                    )
                )
            )
        ),
        _Country(
            "Moldova", "MD", listOf(
                _City(
                    "Kishinev", "KIV", listOf(
                        _Airport("Kishinev", "KIV", 46.92770004272461, 28.930999755859375)
                    )
                )
            )
        ),
        _Country(
            "Netherlands", "NL", listOf(
                _City(
                    "Amsterdam", "AMS", listOf(
                        _Airport("Schiphol", "AMS", 52.308601, 4.76389)
                    )
                ),
                _City(
                    "Groningen", "GRQ", listOf(
                        _Airport("Eelde", "GRQ", 53.1197013855, 6.57944011688)
                    )
                )
            )
        ),
        _Country(
            "Norway", "NO", listOf(
                _City(
                    "Aalesund", "AES", listOf(
                        _Airport("Vigra", "AES", 62.5625, 6.119699954986572)
                    )
                ),
                _City(
                    "Alta", "ALF", listOf(
                        _Airport("Alta", "ALF", 69.976097106934, 23.371700286865)
                    )
                ),
                _City(
                    "Andenes", "ANX", listOf(
                        _Airport("Andoya", "ANX", 69.292503356934, 16.144199371338)
                    )
                ),
                _City(
                    "Bardufoss", "BDU", listOf(
                        _Airport("Bardufoss", "BDU", 69.055801391602, 18.540399551392)
                    )
                ),
                _City(
                    "Batsfjord", "BJF", listOf(
                        _Airport("Batsfjord", "BJF", 70.60050201416, 29.691400527954)
                    )
                ),
                _City(
                    "Bergen", "BGO", listOf(
                        _Airport("Flesland", "BGO", 60.29339981, 5.218140125)
                    )
                ),
                _City(
                    "Berlevag", "BVG", listOf(
                        _Airport("Berlevag", "BVG", 70.871399, 29.034201)
                    )
                ),
                _City(
                    "Bodo", "BOO", listOf(
                        _Airport("Bodo", "BOO", 67.26920318603516, 14.365300178527832)
                    )
                ),
                _City(
                    "Bronnoysund", "BNN", listOf(
                        _Airport("Bronnoy", "BNN", 65.461097717285, 12.217499732971)
                    )
                ),
                _City(
                    "Florø", "FRO", listOf(
                        _Airport("Florø", "FRO", 61.583599090576, 5.0247201919556)
                    )
                ),
                _City(
                    "Forde", "FDE", listOf(
                        // # IngenLikaFørde
                    )
                ),
                _City(
                    "Hammerfest", "HFT", listOf(
                        _Airport("Hammerfest", "HFT", 70.679702758789, 23.668600082397)
                    )
                ),
                _City(
                    "Harstad-Narvik", "EVE", listOf(
                        _Airport("Evenes", "EVE", 68.491302490234, 16.678100585938)
                    )
                ),
                _City(
                    "Hasvik", "HAA", listOf(
                        _Airport("Hasvik", "HAA", 70.486701965332, 22.139699935913)
                    )
                ),
                _City(
                    "Haugesund", "HAU", listOf(
                        _Airport("Karmoy", "HAU", 59.34529876709, 5.2083601951599)
                    )
                ),
                _City(
                    "Honningsvag", "HVG", listOf(
                        _Airport("Valan", "HVG", 71.009696960449, 25.983600616455)
                    )
                ),
                _City(
                    "Kirkenes", "KKN", listOf(
                        _Airport("Hoybuktmoen", "KKN", 69.725799560547, 29.891300201416)
                    )
                ),
                _City(
                    "Kristiansand", "KRS", listOf(
                        _Airport("Kjevik", "KRS", 58.204201, 8.08537)
                    )
                ),
                _City(
                    "Kristiansund", "KSU", listOf(
                        _Airport("Kvernberget", "KSU", 63.111801147461, 7.824520111084)
                    )
                ),
                _City(
                    "Lakselv", "LKL", listOf(
                        _Airport("Banak", "LKL", 70.068801879883, 24.973499298096)
                    )
                ),
                _City(
                    "Leknes", "LKN", listOf(
                        _Airport("Leknes", "LKN", 68.152496337891, 13.609399795532)
                    )
                ),
                _City(
                    "Longyearbyen", "LYR", listOf(
                        _Airport("Svalbard", "LYR", 78.246101379395, 15.465600013733)
                    )
                ),
                _City(
                    "Mehamn", "MEH", listOf(
                        _Airport("Mehamn", "MEH", 71.02970123291, 27.826700210571)
                    )
                ),
                _City(
                    "Mo i Rana", "MQN", listOf(
                        _Airport("Rossvoll", "MQN", 66.363899230957, 14.301400184631)
                    )
                ),
                _City(
                    "Molde", "MOL", listOf(
                        _Airport("Aro", "MOL", 62.744701385498, 7.2624998092651)
                    )
                ),
                _City(
                    "Mosjoen", "MJF", listOf(
                        _Airport("Kjaerstad", "MJF", 65.783996582031, 13.214900016785)
                    )
                ),
                _City(
                    "Namsos", "OSY", listOf(
                        _Airport("Hoknersora", "OSY", 64.472198486328, 11.57859992981)
                    )
                ),
                _City(
                    "Orsta-Volda", "HOV", listOf(
                        _Airport("Hovden", "HOV", 62.180000305176, 6.0741000175476)
                    )
                ),
                _City(
                    "Oslo", "OSL", listOf(
                        _Airport("Gardermoen", "OSL", 60.193901062012, 11.100399971008)
                    )
                ),
                _City(
                    "Rorvik", "RVK", listOf(
                        _Airport("Ryum", "RVK", 64.838302612305, 11.14610004425)
                    )
                ),
                _City(
                    "Roros", "RRS", listOf(
                        _Airport("Roros", "RRS", 62.578399658203, 11.342300415039)
                    )
                ),
                _City(
                    "Rost", "RET", listOf(
                        _Airport("Rost", "RET", 67.527801513672, 12.103300094604)
                    )
                ),
                _City(
                    "Sandane", "SDN", listOf(
                        _Airport("Anda", "SDN", 61.830001831055, 6.1058301925659)
                    )
                ),
                _City(
                    "Sandnessjoen", "SSJ", listOf(
                        _Airport("Stokka", "SSJ", 65.956802368164, 12.468899726868)
                    )
                ),
                _City(
                    "Sogndal", "SOG", listOf(
                        _Airport("Haukasen", "SOG", 61.156101, 7.13778)
                    )
                ),
                _City(
                    "Sorkjosen", "SOJ", listOf(
                        _Airport("Sorkjosen", "SOJ", 69.786796569824, 20.959400177002)
                    )
                ),
                _City(
                    "Stavanger", "SVG", listOf(
                        _Airport("Sola", "SVG", 58.876701354, 5.6377801895)
                    )
                ),
                _City(
                    "Stokmarknes", "SKN", listOf(
                        _Airport("Skagen", "SKN", 68.578826904297, 15.033416748047)
                    )
                ),
                _City(
                    "Stord", "SRP", listOf(
                        _Airport("Sorstokken", "SRP", 59.791900634765625, 5.340849876403809)
                    )
                ),
                _City(
                    "Svolvaer", "SVJ", listOf(
                        _Airport("Helle", "SVJ", 68.243301391602, 14.669199943542)
                    )
                ),
                _City(
                    "Sandefjord", "TRF", listOf(
                        _Airport("Torp", "TRF", 59.1866989136, 10.258600235)
                    )
                ),
                _City(
                    "Tromso", "TOS", listOf(
                        _Airport("Langnes", "TOS", 69.68329620361328, 18.918899536132812)
                    )
                ),
                _City(
                    "Trondheim", "TRD", listOf(
                        _Airport("Vaernes", "TRD", 63.4578018, 10.9239998)
                    )
                ),
                _City(
                    "Vadso", "VDS", listOf(
                        _Airport("Vadso", "VDS", 70.065299987793, 29.844699859619)
                    )
                ),
                _City(
                    "Vardo", "VAW", listOf(
                        _Airport("Svartnes", "VAW", 70.355400085449, 31.044900894165)
                    )
                )
            )
        ),
        _Country(
            "Poland", "PL", listOf(
                _City(
                    "Gdansk", "GDN", listOf(
                        _Airport("Lech Walesa", "GDN", 54.377601623535156, 18.46619987487793)
                    )
                ),
                _City(
                    "Krakow", "KRK", listOf(
                        _Airport("Balice John Paul II", "KRK", 50.077702, 19.7848)
                    )
                ),
                _City(
                    "Poznan", "POZ", listOf(
                        _Airport("Lawica H. Wieniawski", "POZ", 52.421001434299995, 16.8262996674)
                    )
                ),
                _City(
                    "Szczecin", "SZZ", listOf(
                        _Airport("Szczecin", "SZZ", 53.584701538100006, 14.902199745199999)
                    )
                ),
                _City(
                    "Warsaw", "WAW", listOf(
                        _Airport("Chopin", "WAW", 52.1656990051, 20.967100143399996)
                    )
                ),
                _City(
                    "Wroclaw", "WRO", listOf(
                        _Airport("Copernicus", "WRO", 51.1026992798, 16.885799408)
                    )
                )
            )
        ),
        _Country(
            "Portugal", "PT", listOf(
                _City(
                    "Faro Algarve", "FAO", listOf(
                        _Airport("Algarve Intl", "FAO", 37.0144004822, -7.96590995789)
                    )
                ),
                _City(
                    "Lisbon", "LIS", listOf(
                        _Airport("Humberto Delgado", "LIS", 38.7813, -9.13592)
                    )
                ),
                _City(
                    "Funchal Madeira", "FNC", listOf(
                        _Airport("C. Ronaldo Madeira", "FNC", 32.697899, -16.7745)
                    )
                ),
                _City(
                    "Porto", "OPO", listOf(
                        _Airport("Francisco Sa Carneiro", "OPO", 41.2481002808, -8.68138980865)
                    )
                )
            )
        ),
        _Country(
            "Romania", "RO", listOf(
                _City(
                    "Bucharest", "BUH", listOf(
                        _Airport("Henri Coanda", "OTP", 44.5711111, 26.085)
                    )
                )
            )
        ),
        _Country(
            "Russia", "RU", listOf(
                _City(
                    "St Petersburg", "LED", listOf(
                        _Airport("Pulkovo", "LED", 59.80030059814453, 30.262500762939453)
                    )
                )
            )
        ),
        _Country(
            "Serbia", "RS", listOf(
                _City(
                    "Belgrade", "BEG", listOf(
                        _Airport("Nikola Tesla", "BEG", 44.8184013367, 20.3090991974)
                    )
                )
            )
        ),
        _Country(
            "Slovenia", "SI", listOf(
                _City(
                    "Ljubljana", "LJU", listOf(
                        _Airport("Joze Pucnik", "LJU", 46.223701, 14.4576)
                    )
                )
            )
        ),
        _Country(
            "Spain", "ES", listOf(
                _City(
                    "Alicante", "ALC", listOf(
                        _Airport("Elche", "ALC", 38.28219985961914, -0.5581560134887695)
                    )
                ),
                _City(
                    "Bilbao", "BIO", listOf(
                        _Airport("Bilbao", "BIO", 43.30110168457031, -2.9106099605560303)
                    )
                ),
                _City(
                    "Fuerteventura", "FUE", listOf(
                        _Airport("El Matorral", "FUE", 28.452699661254883, -13.863800048828125)
                    )
                ),
                _City(
                    "Ibiza", "IBZ", listOf(
                        _Airport("Ibiza", "IBZ", 38.872898101800004, 1.3731199502899998)
                    )
                ),
                _City(
                    "Barcelona", "BCN", listOf(
                        _Airport("El Prat", "BCN", 41.2971, 2.07846)
                    )
                ),
                _City(
                    "Gran Canaria", "LPA", listOf(
                        _Airport("Las Palmas / Gran Canaria", "LPA", 27.931900024414062, -15.38659954071045)
                    )
                ),
                _City(
                    "Madrid", "MAD", listOf(
                        _Airport("Barajas Adolfo Suarez", "MAD", 40.471926, -3.56264)
                    )
                ),
                _City(
                    "Malaga", "AGP", listOf(
                        _Airport("Costa del Sol ", "AGP", 36.67490005493164, -4.499110221862793)
                    )
                ),
                _City(
                    "Menorca", "MAH", listOf(
                        _Airport("Menorca", "MAH", 39.86259841918945, 4.218649864196777)
                    )
                ),
                _City(
                    "Palma de Mallorca", "PMI", listOf(
                        _Airport("Palma de Mallorca", "PMI", 39.551700592, 2.73881006241)
                    )
                ),
                _City(
                    "Tenerife", "TCI", listOf(
                        _Airport("Tenerife South", "TFS", 28.044500351, -16.5725002289)
                    )
                )
            )
        ),
        _Country(
            "Sweden", "SE", listOf(
                _City(
                    "Angelholm / Helsingborg", "AGH", listOf(
                        _Airport("Angelholm", "AGH", 56.29610061645508, 12.847100257873535)
                    )
                ),
                _City(
                    "Arvidsjaur", "AJR", listOf(
                        _Airport("Arvidsjaur", "AJR", 65.59030151367188, 19.28190040588379)
                    )
                ),
                _City(
                    "Gallivare", "GEV", listOf(
                        _Airport("Gallivare", "GEV", 67.13240051269531, 20.814599990844727)
                    )
                ),
                _City(
                    "Gothenburg", "GOT", listOf(
                        _Airport("Landvetter", "GOT", 57.662799835205, 12.279800415039)
                    )
                ),
                _City(
                    "Kalmar", "KLR", listOf(
                        _Airport("Kalmar", "KLR", 56.68550109863281, 16.287599563598633)
                    )
                ),
                _City(
                    "Kiruna", "KRN", listOf(
                        _Airport("Kiruna", "KRN", 67.821998596191, 20.336799621582)
                    )
                ),
                _City(
                    "Lulea", "LLA", listOf(
                        _Airport("Kallax", "LLA", 65.543800354004, 22.121999740601)
                    )
                ),
                _City(
                    "Malmo", "MMA", listOf(
                        _Airport("Sturup", "MMX", 55.536305364, 13.376197814900001)
                    )
                ),
                _City(
                    "Ornskoldsvik", "OER", listOf(
                        _Airport("Ornskoldsvik", "OER", 63.40829849243164, 18.989999771118164)
                    )
                ),
                _City(
                    "Are / Ostersund", "OSD", listOf(
                        _Airport("Are / Ostersund", "OSD", 63.194400787354, 14.50030040741)
                    )
                ),
                _City(
                    "Ronneby", "RNB", listOf(
                        _Airport("Kallinge", "RNB", 56.266700744629, 15.265000343323)
                    )
                ),
                _City(
                    "Skelleftea", "SFT", listOf(
                        _Airport("Skelleftea", "SFT", 64.62480163574219, 21.076900482177734)
                    )
                ),
                _City(
                    "Stockholm", "STO", listOf(
                        _Airport("Arlanda", "ARN", 59.651901245117, 17.918600082397)
                    )
                ),
                _City(
                    "Sundsvall / Timrå", "SDL", listOf(
                        _Airport("Sundsvall / Timra", "SDL", 62.528099060058594, 17.443899154663086)
                    )
                ),
                _City(
                    "Umea", "UME", listOf(
                        _Airport("Umea", "UME", 63.791801452637, 20.282800674438)
                    )
                ),
                _City(
                    "Visby Gotland", "VBY", listOf(
                        _Airport("Visby", "VBY", 57.662799835205, 18.346200942993)
                    )
                )
            )
        ),
        _Country(
            "Switzerland", "CH", listOf(
                _City(
                    "Basel", "BSL", listOf(
                        _Airport("Euro Airport", "BSL", 47.59, 7.5291667)
                    )
                ),
                _City(
                    "Geneva", "GVA", listOf(
                        _Airport("Cointrin", "GVA", 46.23809814453125, 6.108950138092041)
                    )
                ),
                _City(
                    "Lugano", "LUG", listOf(
                        _Airport("Agno", "LUG", 46.00429916379999, 8.9105796814)
                    )
                ),
                _City(
                    "Zurich", "ZRH", listOf(
                        _Airport("Kloten", "ZRH", 47.464699, 8.54917)
                    )
                )
            )
        ),
        _Country(
            "Turkey", "TR", listOf(
                _City(
                    "Ankara", "ANK", listOf(
                        _Airport("Esenboga", "ESB", 40.128101348899996, 32.995098114)
                    )
                ),
                _City(
                    "Antalya", "AYT", listOf(
                        _Airport("Antalya", "AYT", 36.898701, 30.800501)
                    )
                ),
                _City(
                    "Bodrum", "BXN", listOf(
                        _Airport("Milas", "BJV", 37.25059890749999, 27.6643009186)
                    )
                ),
                _City(
                    "Dalaman", "DLM", listOf(
                        _Airport("Dalaman", "DLM", 36.7131004333, 28.7924995422)
                    )
                ),
                _City(
                    "Alanya", "GZP", listOf(
                        _Airport("Gazipasa", "GZP", 36.299217, 32.300598)
                    )
                ),
                _City(
                    "Istanbul", "IST", listOf(
                        _Airport("Ataturk", "IST", 40.976898, 28.8146)
                    )
                ),
                _City(
                    "Izmir", "IZM", listOf(
                        _Airport("Adnan Menderes", "ADB", 38.2924003601, 27.156999588)
                    )
                )
            )
        ),
        _Country(
            "Ukraine", "UA", listOf(
                _City(
                    "Kiev", "IEV", listOf(
                        _Airport("Boryspil", "KBP", 50.345001220703125, 30.894699096679688)
                    )
                ),
                _City(
                    "Lvov", "LWO", listOf(
                        _Airport("Lvov", "LWO", 49.8125, 23.956100463867188)
                    )
                )
            )
        ),
        _Country(
            "United Kingdom", "GB", listOf(
                _City(
                    "Aberdeen", "ABZ", listOf(
                        _Airport("Aberdeen Intl", "ABZ", 57.201900482177734, -2.197779893875122)
                    )
                ),
                _City(
                    "Belfast", "BFS", listOf(
                        _Airport("G. Best City Airport", "BHD", 54.618099212646484, -5.872499942779541)
                    )
                ),
                _City(
                    "Birmingham", "BHX", listOf(
                        _Airport("Birmingham", "BHX", 52.453899383499994, -1.74802994728)
                    )
                ),
                _City(
                    "Edinburgh", "EDI", listOf(
                        _Airport("Edinburgh", "EDI", 55.95000076293945, -3.372499942779541)
                    )
                ),
                _City(
                    "Liverpool", "LPL", listOf(
                        _Airport("John Lennon", "LPL", 53.33359909057617, -2.849720001220703)
                    )
                ),
                _City(
                    "London", "LON", listOf(
                        _Airport("London Heathrow", "LHR", 51.4706, -0.461941),
                        _Airport("Stansted", "STN", 51.8849983215, 0.234999999404)
                    )
                ),
                _City(
                    "Manchester", "MAN", listOf(
                        _Airport("Manchester", "MAN", 53.35369873046875, -2.2749500274658203)
                    )
                ),
                _City(
                    "Newquay", "NQY", listOf(
                        _Airport("Cornwall", "NQY", 50.44060134887695, -4.995409965515137)
                    )
                )
            )
        ),
        _Country(
            "Australia", "AU", listOf(
                _City(
                    "Adelaide", "ADL", listOf(
                        _Airport("Adelaide", "ADL", -34.945, 138.531006)
                    )
                ),
                _City(
                    "Brisbane", "BNE", listOf(
                        _Airport("Brisbane", "BNE", -27.384199142456055, 153.11700439453125)
                    )
                ),
                _City(
                    "Canberra", "CBR", listOf(
                        _Airport("Canberra", "CBR", -35.30690002441406, 149.19500732421875)
                    )
                ),
                _City(
                    "Hobart", "HBA", listOf(
                        _Airport("Hobart", "HBA", -42.836101532, 147.509994507)
                    )
                ),
                _City(
                    "Melbourne", "MEL", listOf(
                        _Airport("Melbourne", "MEL", -37.673302, 144.843002)
                    )
                ),
                _City(
                    "Perth", "PER", listOf(
                        _Airport("Perth", "PER", -31.94029998779297, 115.96700286865234)
                    )
                ),
                _City(
                    "Sydney", "SYD", listOf(
                        _Airport("Kingsford Smith", "SYD", -33.94609832763672, 151.177001953125)
                    )
                )
            )
        ),
        _Country(
            "Egypt", "EG", listOf(
                _City(
                    "Cairo", "CAI", listOf(
                        _Airport("Cairo Intl", "CAI", 30.12190055847168, 31.40559959411621)
                    )
                )
            )
        ),
        _Country(
            "Ethiopia", "ET", listOf(
                _City(
                    "Addis Ababa", "ADD", listOf(
                        _Airport("Bole ", "ADD", 8.97789001465, 38.799301147499996)
                    )
                )
            )
        ),
        _Country(
            "French Polynesia", "PF", listOf(
                _City(
                    "Tahiti", "PPT", listOf(
                        _Airport("Tahiti", "PPT", -17.5536994934, -149.606994629)
                    )
                )
            )
        ),
        _Country(
            "New Caledonia", "NC", listOf(
                _City(
                    "Noumea", "NOU", listOf(
                        _Airport("La Tontouta", "NOU", -22.01460075378418, 166.21299743652344)
                    )
                )
            )
        ),
        _Country(
            "New Zealand", "NZ", listOf(
                _City(
                    "Auckland", "AKL", listOf(
                        _Airport("Auckland", "AKL", -37.008098602299995, 174.792007446)
                    )
                ),
                _City(
                    "Christchurch", "CHC", listOf(
                        _Airport("Christchurch Intl", "CHC", -43.48939895629883, 172.53199768066406)
                    )
                ),
                _City(
                    "Queenstown", "ZQN", listOf(
                        _Airport("Queenstown", "ZQN", -45.0210990906, 168.738998413)
                    )
                ),
                _City(
                    "Wellington", "WLG", listOf(
                        _Airport("Wellington", "WLG", -41.3272018433, 174.804992676)
                    )
                )
            )
        ),
        _Country(
            "South Africa", "ZA", listOf(
                _City(
                    "Cape Town", "CPT", listOf(
                        _Airport("Cape Town Intl", "CPT", -33.9648017883, 18.6016998291)
                    )
                ),
                _City(
                    "Johannesburg", "JNB", listOf(
                        _Airport("O. R. Tambo", "JNB", -26.1392, 28.246)
                    )
                )
            )
        )
    )

    val regions = listOf(
        _Region(
            "America", listOf(
                "BS",
                "CA",
                "KY",
                "CO",
                "CR",
                "DO",
                "SV",
                "JM",
                "MX",
                "PA",
                "PR",
                "SX",
                "US"
            )
        ),
        _Region(
            "Asia", listOf(
                "KH",
                "CN",
                "CY",
                "IN",
                "ID",
                "JP",
                "KR",
                "MY",
                "PH",
                "SG",
                "TW",
                "TH",
                "VN"
            )
        ),
        _Region(
            "Europe", listOf(
                "AL",
                "AT",
                "BE",
                "BA",
                "BG",
                "HR",
                "CZ",
                "DK",
                "EE",
                "FO",
                "FI",
                "FR",
                "DE",
                "GR",
                "HU",
                "IS",
                "IE",
                "IT",
                "XK",
                "LV",
                "LB",
                "LT",
                "LU",
                "MK",
                "MT",
                "MD",
                "NL",
                "NO",
                "PL",
                "PT",
                "RO",
                "RU",
                "RS",
                "SI",
                "ES",
                "SE",
                "CH",
                "TR",
                "UA",
                "GB"
            )
        ),
        _Region(
            "Rest of the world", listOf(
                "AU",
                "EG",
                "ET",
                "PF",
                "NC",
                "NZ",
                "ZA"
            )
        ),
        _Region(
            "Scandinavia", listOf(
                "DK",
                "NO",
                "SE"
            )
        )
    )

    val countryIds = mutableMapOf<String, Long>()
    val countryDao = database.countryDao()
    val cityDao = database.cityDao()
    val airportDao = database.airportDao()
    countries.forEach { country ->
        val countryId = countryDao.insert(
            Country(
                name = country.name,
                code = country.code
            )
        )
        countryIds.put(country.code, countryId)
        country.cities.forEach { city ->
            val cityId = cityDao.insert(
                City(
                    name = city.name,
                    code = city.code,
                    countryId = countryId
                )
            )
            airportDao.insertAll(
                *city.airports.map { airport ->
                    Airport(
                        name = airport.name,
                        iata = airport.iata,
                        cityId = cityId,
                        latitude = airport.latitude,
                        longitude = airport.longitude
                    )
                }.toTypedArray()
            )
        }
    }

    val regionDao = database.regionDao()
    val regionCountryJoinDao = database.regionCountryJoinDao()
    regions.forEach { region ->
        val regionId = regionDao.insert(Region(name = region.name))

        regionCountryJoinDao.insert(
            *region.countries.map {
                RegionCountryJoin(
                    regionId,
                    countryIds.get(it)!!
                )
            }.toTypedArray()
        )
    }


}