(ns strain)

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (->
    pred
    (filter coll)
    vec))

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (->
    pred
    (remove coll)
    vec))
