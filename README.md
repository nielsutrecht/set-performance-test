# set-performance-test
Performance tests for different set implementations

## Results

### Int lookup

    Benchmark       (variant)   Mode  Cnt       Score       Error   Units
                     equals,,1  thrpt    5  167076.919 ± 30474.429  ops/ms
                  arrayList,,1  thrpt    5   43197.481 ±  6944.443  ops/ms
                 arrayList,,10  thrpt    5   28093.992 ±  7342.178  ops/ms
                arrayList,,100  thrpt    5    7119.674 ±  4032.913  ops/ms
               arrayList,,1000  thrpt    5     623.889 ±    76.857  ops/ms
                      array,,1  thrpt    5  126416.868 ± 11394.923  ops/ms
                     array,,10  thrpt    5   82317.588 ± 10195.561  ops/ms
                    array,,100  thrpt    5   23436.174 ±  2237.413  ops/ms
                   array,,1000  thrpt    5    1998.318 ±   188.202  ops/ms
                    arrayBS,,1  thrpt    5   93299.463 ± 13338.988  ops/ms
                   arrayBS,,10  thrpt    5   74768.218 ±  2120.938  ops/ms
                  arrayBS,,100  thrpt    5   39180.737 ±  5392.630  ops/ms
                 arrayBS,,1000  thrpt    5   26437.454 ±   714.092  ops/ms
            javaHashSet,0.75,1  thrpt    5   53577.827 ± 14857.373  ops/ms
           javaHashSet,0.75,10  thrpt    5   51048.394 ±  5580.798  ops/ms
          javaHashSet,0.75,100  thrpt    5   49907.362 ±  4348.223  ops/ms
         javaHashSet,0.75,1000  thrpt    5   53859.199 ± 11053.784  ops/ms
             javaHashSet,0.5,1  thrpt    5   49641.733 ±  4824.221  ops/ms
            javaHashSet,0.5,10  thrpt    5   50111.088 ±  4642.078  ops/ms
           javaHashSet,0.5,100  thrpt    5   46955.098 ±  5826.060  ops/ms
          javaHashSet,0.5,1000  thrpt    5   52976.464 ± 10892.996  ops/ms
            javaHashSet,0.25,1  thrpt    5   37684.378 ± 19614.095  ops/ms
           javaHashSet,0.25,10  thrpt    5   47940.633 ± 13782.052  ops/ms
          javaHashSet,0.25,100  thrpt    5   50700.195 ±  9341.487  ops/ms
         javaHashSet,0.25,1000  thrpt    5   55458.100 ± 13009.433  ops/ms
            hppcHashSet,0.75,1  thrpt    5  101139.040 ±  1317.760  ops/ms
           hppcHashSet,0.75,10  thrpt    5   83113.973 ±  1086.238  ops/ms
          hppcHashSet,0.75,100  thrpt    5  100202.154 ±  4368.368  ops/ms
         hppcHashSet,0.75,1000  thrpt    5   77840.125 ±   545.954  ops/ms
             hppcHashSet,0.5,1  thrpt    5  117715.973 ± 27314.240  ops/ms
            hppcHashSet,0.5,10  thrpt    5  107203.202 ±  4267.496  ops/ms
           hppcHashSet,0.5,100  thrpt    5  108115.802 ±   464.611  ops/ms
          hppcHashSet,0.5,1000  thrpt    5   85618.420 ±  3544.607  ops/ms
            hppcHashSet,0.25,1  thrpt    5  122830.133 ±  4030.361  ops/ms
           hppcHashSet,0.25,10  thrpt    5  124436.186 ±  2895.465  ops/ms
          hppcHashSet,0.25,100  thrpt    5  110694.575 ±  1887.642  ops/ms
         hppcHashSet,0.25,1000  thrpt    5  106523.050 ± 11636.130  ops/ms
         hppcScatterSet,0.75,1  thrpt    5  119992.836 ±  1831.932  ops/ms
        hppcScatterSet,0.75,10  thrpt    5   93886.673 ±  3622.606  ops/ms
       hppcScatterSet,0.75,100  thrpt    5  106058.967 ±  3515.752  ops/ms
      hppcScatterSet,0.75,1000  thrpt    5  116291.810 ±  1929.837  ops/ms
          hppcScatterSet,0.5,1  thrpt    5  121767.253 ±  7867.309  ops/ms
         hppcScatterSet,0.5,10  thrpt    5  111080.604 ±  2735.093  ops/ms
        hppcScatterSet,0.5,100  thrpt    5  107183.230 ±  5093.162  ops/ms
       hppcScatterSet,0.5,1000  thrpt    5  104493.953 ±  3358.466  ops/ms
         hppcScatterSet,0.25,1  thrpt    5  121153.945 ±  4310.835  ops/ms
        hppcScatterSet,0.25,10  thrpt    5  125078.838 ±  4274.423  ops/ms
       hppcScatterSet,0.25,100  thrpt    5  128496.941 ±  4792.980  ops/ms
      hppcScatterSet,0.25,1000  thrpt    5  119439.229 ±  3516.126  ops/ms
           troveHashSet,0.75,1  thrpt    5   82037.203 ±  2509.026  ops/ms
          troveHashSet,0.75,10  thrpt    5   54954.185 ±  2036.991  ops/ms
         troveHashSet,0.75,100  thrpt    5   55413.000 ±  3595.254  ops/ms
        troveHashSet,0.75,1000  thrpt    5   41900.664 ±  1212.870  ops/ms
            troveHashSet,0.5,1  thrpt    5   82936.119 ±  2280.719  ops/ms
           troveHashSet,0.5,10  thrpt    5   72123.884 ±  1701.526  ops/ms
          troveHashSet,0.5,100  thrpt    5   72290.401 ±  1239.584  ops/ms
         troveHashSet,0.5,1000  thrpt    5   68996.741 ±  4479.843  ops/ms
           troveHashSet,0.25,1  thrpt    5   92920.656 ±   584.768  ops/ms
          troveHashSet,0.25,10  thrpt    5   95258.572 ±  2468.758  ops/ms
         troveHashSet,0.25,100  thrpt    5   64908.379 ±  1106.150  ops/ms
        troveHashSet,0.25,1000  thrpt    5   68756.180 ±   495.877  ops/ms
              fuHashSet,0.75,1  thrpt    5  131285.581 ±  2101.035  ops/ms
             fuHashSet,0.75,10  thrpt    5   94082.950 ±  6680.450  ops/ms
            fuHashSet,0.75,100  thrpt    5  112538.742 ±  1931.086  ops/ms
           fuHashSet,0.75,1000  thrpt    5  128297.604 ±  2992.584  ops/ms
               fuHashSet,0.5,1  thrpt    5  129208.802 ±  5442.778  ops/ms
              fuHashSet,0.5,10  thrpt    5  114316.800 ±  1369.475  ops/ms
             fuHashSet,0.5,100  thrpt    5  112053.789 ±  2874.252  ops/ms
            fuHashSet,0.5,1000  thrpt    5  114871.977 ±  3835.928  ops/ms
              fuHashSet,0.25,1  thrpt    5  130077.327 ±  9491.956  ops/ms
             fuHashSet,0.25,10  thrpt    5  148688.457 ±  5108.315  ops/ms
            fuHashSet,0.25,100  thrpt    5  136472.025 ±  6409.173  ops/ms
           fuHashSet,0.25,1000  thrpt    5  153268.098 ± 12851.128  ops/ms

Process finished with exit code 0

### String lookup

    Benchmark                           (implementation)   Mode  Cnt      Score      Error   Units
    StringLookupBenchmark.stringLookup       javaHashSet  thrpt    5  63296.442 ± 5291.635  ops/ms
    StringLookupBenchmark.stringLookup       hppcHashSet  thrpt    5  75777.846 ± 4259.538  ops/ms
    StringLookupBenchmark.stringLookup    hppcScatterSet  thrpt    5  93485.772 ± 1942.056  ops/ms