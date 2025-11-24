(ns leap)

(defn leap-year?
  "Returns true if the given year is a leap year;
  otherwise, it returns false."
  [year]
   (and (= 0 (rem year 4)) (or (not= 0 (rem year 100)) (= 0 (rem year 400)))))
