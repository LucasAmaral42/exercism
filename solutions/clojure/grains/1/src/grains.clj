(ns grains)

(defn square
  "Returns the number of grains on the n-th chessboard square."
  ([n]
    (square n 1N))
  ([n sum]
    (let [n (dec n)]
      (if (pos? n)
        (let [sum (* sum 2)]
          (square n sum))
        sum))))

(defn total
  "Returns the total number of grains on the chessboard."
  []
  (dec (square 65 1N)))
