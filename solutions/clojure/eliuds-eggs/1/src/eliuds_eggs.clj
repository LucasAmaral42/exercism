(ns eliuds-eggs)

(defn egg-count
  "Returns the number of 1 bits in the binary representation of the given number."
  ([number]
   (egg-count number ()))
  ([number binary-number]
   (if (zero? number)
     (count (filter #(pos? %) binary-number))
     (let [rest (mod number 2)
           number (int (/ number 2))
           binary-number (conj binary-number rest)]
       (egg-count number binary-number)))))
