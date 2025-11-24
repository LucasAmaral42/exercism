(ns difference-of-squares
  (:require [clojure.math :as math]))

(defn create-range
  [N]
  (range (inc N)))

(defn square-of-sum
  "Returns the square of the sum of the numbers up to N."
  [N]
  (let [natural-numbers (create-range N)]
    (int (math/pow (reduce + natural-numbers) 2))))

(defn sum-of-squares
  "Returns the sum of the squares of the numbers up to N."
  [N]
  (let [natural-numbers (create-range N)]
    (int (reduce #(+ %1 (math/pow %2 2)) natural-numbers))))

(defn difference
  "Returns the difference between the square of the sum
  and the sum of the squares of the numbers up to N."
  [N]
  (->
    (square-of-sum N)
    (- (sum-of-squares N))))
