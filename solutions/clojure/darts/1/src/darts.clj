(ns darts)

(defn score
  "Calculates the score of a dart throw."
  [x y]
  (let [x (Math/pow (- x 0) 2)
        y (Math/pow (- y 0) 2)
        position (Math/sqrt (+ x y))]
    (cond
      (> position 10) 0
      (> position 5) 1
      (> position 1) 5
      :else 10)))
