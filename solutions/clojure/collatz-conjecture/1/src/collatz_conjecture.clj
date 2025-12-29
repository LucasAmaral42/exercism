(ns collatz-conjecture)

(defn collatz
  "Returns the number of steps for num to reach 1
  according to the Collatz Conjecture."
  ([num]
   (collatz num 0))
  ([num step]
   (cond
     (= num 1)   step
     (even? num) (-> num
                   (/ 2)
                   (collatz (inc step)))
     (odd? num)  (-> num
                   (* 3)
                   inc
                   (collatz (inc step))))))
