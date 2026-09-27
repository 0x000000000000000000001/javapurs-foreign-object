    // Port of Foreign/Object.js. Objects are LinkedHashMaps, the same
    // representation the record machinery uses.
    public static Object _copyST = (java.util.function.Function<Object, Object>) (m) ->
        (java.util.function.Supplier<Object>) () -> new java.util.LinkedHashMap<>((java.util.Map<String, Object>) m);

    public static Object empty = java.util.Collections.emptyMap();

    public static Object runST = (java.util.function.Function<Object, Object>) (f) ->
        ((java.util.function.Supplier<Object>) f).get();

    public static Object _fmapObject = (java.util.function.Function<Object, Object>) (m0) ->
        (java.util.function.Function<Object, Object>) (f) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m0;
            java.util.Map<String, Object> out = new java.util.LinkedHashMap<>();
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                out.put(entry.getKey(), ((java.util.function.Function<Object, Object>) f).apply(entry.getValue()));
            }
            return out;
        };

    public static Object _mapWithKey = (java.util.function.Function<Object, Object>) (m0) ->
        (java.util.function.Function<Object, Object>) (f) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m0;
            java.util.Map<String, Object> out = new java.util.LinkedHashMap<>();
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                out.put(entry.getKey(),
                    ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(entry.getKey())).apply(entry.getValue()));
            }
            return out;
        };

    public static Object _foldM = (java.util.function.Function<Object, Object>) (bind) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (mz) ->
        (java.util.function.Function<Object, Object>) (m) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
            Object acc = mz;
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                java.util.function.Function<Object, Object> g = z ->
                    ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(z)).apply(key)).apply(value);
                acc = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) bind).apply(acc)).apply(g);
            }
            return acc;
        };

    public static Object _foldSCObject = (java.util.function.Function<Object, Object>) (m) ->
        (java.util.function.Function<Object, Object>) (z) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (fromMaybe) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
            Object acc = z;
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                Object maybeR = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(acc)).apply(entry.getKey())).apply(entry.getValue());
                Object r = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) fromMaybe).apply(null)).apply(maybeR);
                if (r == null) return acc;
                acc = r;
            }
            return acc;
        };

    public static Object all = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (m) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                if (!(Boolean) ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(entry.getKey())).apply(entry.getValue())) return false;
            }
            return true;
        };

    public static Object size = (java.util.function.Function<Object, Object>) (m) ->
        ((java.util.Map<String, Object>) m).size();

    public static Object _lookup = (java.util.function.Function<Object, Object>) (no) ->
        (java.util.function.Function<Object, Object>) (yes) ->
        (java.util.function.Function<Object, Object>) (k) ->
        (java.util.function.Function<Object, Object>) (m) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
            String key = (String) k;
            return source.containsKey(key)
                ? ((java.util.function.Function<Object, Object>) yes).apply(source.get(key))
                : no;
        };

    public static Object _lookupST = (java.util.function.Function<Object, Object>) (no) ->
        (java.util.function.Function<Object, Object>) (yes) ->
        (java.util.function.Function<Object, Object>) (k) ->
        (java.util.function.Function<Object, Object>) (m) ->
            (java.util.function.Supplier<Object>) () -> {
                java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
                String key = (String) k;
                return source.containsKey(key)
                    ? ((java.util.function.Function<Object, Object>) yes).apply(source.get(key))
                    : no;
            };

    public static Object toArrayWithKey = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (m) -> {
            java.util.Map<String, Object> source = (java.util.Map<String, Object>) m;
            Object[] out = new Object[source.size()];
            int index = 0;
            for (java.util.Map.Entry<String, Object> entry : source.entrySet()) {
                out[index++] = ((java.util.function.Function<Object, Object>) ((java.util.function.Function<Object, Object>) f).apply(entry.getKey())).apply(entry.getValue());
            }
            return out;
        };

    public static Object keys = (java.util.function.Function<Object, Object>) (m) ->
        ((java.util.Map<String, Object>) m).keySet().toArray(new Object[0]);
