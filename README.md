# set-performance-test
Performance tests for different set implementations

## Results

### Int lookup

    Benchmark                      (implementation)  (size)   Mode  Cnt       Score       Error   Units
    IntLookupBenchmark.intLookup  javaStringHashSet      10  thrpt    3   11658.309 ±  2529.491  ops/ms
    IntLookupBenchmark.intLookup  javaStringHashSet     100  thrpt    3   11137.743 ±  1278.764  ops/ms
    IntLookupBenchmark.intLookup  javaStringHashSet    1000  thrpt    3   12347.613 ±  3647.861  ops/ms
    IntLookupBenchmark.intLookup        javaHashSet      10  thrpt    3   45819.737 ± 21322.910  ops/ms
    IntLookupBenchmark.intLookup        javaHashSet     100  thrpt    3   47027.118 ±  4953.060  ops/ms
    IntLookupBenchmark.intLookup        javaHashSet    1000  thrpt    3   54120.043 ± 21063.494  ops/ms
    IntLookupBenchmark.intLookup          arrayList      10  thrpt    3   28859.270 ±  4530.193  ops/ms
    IntLookupBenchmark.intLookup          arrayList     100  thrpt    3    8323.383 ±  2084.729  ops/ms
    IntLookupBenchmark.intLookup          arrayList    1000  thrpt    3     606.974 ±   846.140  ops/ms
    IntLookupBenchmark.intLookup              array      10  thrpt    3   88830.441 ± 17333.141  ops/ms
    IntLookupBenchmark.intLookup              array     100  thrpt    3   23481.512 ±  1746.142  ops/ms
    IntLookupBenchmark.intLookup              array    1000  thrpt    3    1951.569 ±   427.602  ops/ms
    IntLookupBenchmark.intLookup            arrayBS      10  thrpt    3   65638.137 ± 37738.894  ops/ms
    IntLookupBenchmark.intLookup            arrayBS     100  thrpt    3   40972.513 ±  3421.407  ops/ms
    IntLookupBenchmark.intLookup            arrayBS    1000  thrpt    3   28240.409 ±  1045.380  ops/ms
    IntLookupBenchmark.intLookup        hppcHashSet      10  thrpt    3  109945.999 ± 10129.766  ops/ms
    IntLookupBenchmark.intLookup        hppcHashSet     100  thrpt    3   99357.896 ± 11740.547  ops/ms
    IntLookupBenchmark.intLookup        hppcHashSet    1000  thrpt    3   90816.820 ±  3353.692  ops/ms
    IntLookupBenchmark.intLookup     hppcScatterSet      10  thrpt    3   94578.496 ±  9995.646  ops/ms
    IntLookupBenchmark.intLookup     hppcScatterSet     100  thrpt    3  105064.438 ± 12149.670  ops/ms
    IntLookupBenchmark.intLookup     hppcScatterSet    1000  thrpt    3  106398.377 ± 98458.949  ops/ms
    
### String lookup

    Benchmark                           (implementation)   Mode  Cnt      Score      Error   Units
    StringLookupBenchmark.stringLookup       javaHashSet  thrpt    5  63296.442 ± 5291.635  ops/ms
    StringLookupBenchmark.stringLookup       hppcHashSet  thrpt    5  75777.846 ± 4259.538  ops/ms
    StringLookupBenchmark.stringLookup    hppcScatterSet  thrpt    5  93485.772 ± 1942.056  ops/ms