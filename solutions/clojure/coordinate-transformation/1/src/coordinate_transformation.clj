(ns coordinate-transformation)

(defn translate2d
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [dx dy]
  (fn [x y]
    [(+ x dx) (+ y dy)]))

(defn scale2d
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [sx sy]
  (fn [x y]
    [(* x sx) (* y sy)]))

(defn compose-transform
  "Create a composition function that returns a function that
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y]
    (let [[updated-x updated-y] (f x y)]
      (g updated-x updated-y))))

(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [memoized-result (atom nil)
        memoized-arguments (atom nil)]
    (fn [x y]
      (if (and (= x (first @memoized-arguments)) (= y (second @memoized-arguments)))
        @memoized-result
        (do
          (reset! memoized-result (f x y))
          (reset! memoized-arguments [x y])
          @memoized-result)))))
