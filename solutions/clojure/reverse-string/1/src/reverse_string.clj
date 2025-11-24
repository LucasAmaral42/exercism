(ns reverse-string)

(defn reverse-string
  "Reverses the given string."
  ([s] (reverse-string s ""))
  ([s acc]
   (if (clojure.string/blank? s)
     acc
     (let [last-char (last s)
           s (apply str (butlast s))
           acc (str acc last-char)]
       (reverse-string s acc)))))
