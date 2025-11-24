(ns resistor-color-duo)

(def colors-vec
  ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"])

(defn resistor-value
  "Returns the resistor value based on the given colors."
  [colors]
  (let [two-bands (take 2 colors)]
    (->>
      two-bands
      (map #(.indexOf colors-vec %))
      clojure.string/join
      Integer/parseInt)))
