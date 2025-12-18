(ns series)

(defn validate
  [s n]
  (let [string-size (count s)]
    (cond
      (zero? string-size) (throw (IllegalArgumentException. "series cannot be empty"))
      (> n string-size)   (throw (IllegalArgumentException. "slice length cannot be greater than series length"))
      (neg? n)            (throw (IllegalArgumentException. "slice length cannot be negative"))
      (zero? n)           (throw (IllegalArgumentException. "slice length cannot be zero"))
      :else               true)))

(defn slices
  "Returns all contiguous substrings of length n from the string s."
  ([s n]
   (when
     (validate s n)
     (slices s n [])))
  ([s n l]
    (if (< (count s) n)
      l
      (let [slice  (apply str (take n s))
            s      (rest s)
            l      (conj l slice)]
        (slices s n l)))))
