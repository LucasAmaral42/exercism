(ns bird-watcher)

(def last-week 
    [0 2 5 3 7 8 4]
  )

(defn today [birds]
    (last birds)
  )

(defn inc-bird [birds]
    (let [today-index (dec (count birds))]
    (update birds today-index inc))
  )  

(defn day-without-birds? [birds]
    (boolean (some #(= 0 %) birds))
  )

(defn n-days-count [birds n]
    (reduce + (take n birds))
  )

(defn busy-days [birds]
    (count (filter #(>= % 5) birds))
  )

(defn odd-week? [birds]
    (every? identity (map-indexed #(= %2 (mod (inc %1) 2)) birds))
  )
