(ns raindrops)

(defn mount-string
  [num]
  (cond-> nil
    (zero? (mod num 3)) (str "Pling")
    (zero? (mod num 5)) (str "Plang")
    (zero? (mod num 7)) (str "Plong")))

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  (if-let [string (mount-string num)]
    string
    (str num)))
