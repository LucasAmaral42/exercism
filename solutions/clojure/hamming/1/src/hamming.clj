(ns hamming)

(defn diff
 [strand1 strand2 diff-count]
   (if (empty? strand1)
     diff-count
     (let [s1-first (first strand1)
           s2-first (first strand2)
           strand1 (rest strand1)
           strand2 (rest strand2)]
       (if (= s1-first s2-first)
         (diff strand1 strand2 diff-count)
         (->>
           diff-count
           inc
           (diff strand1 strand2))))))

(defn same-size-strands?
  [strand1 strand2]
  (= (count strand1) (count strand2)))

(defn distance
  "Returns the hamming distance between two DNA strands."
  [strand1 strand2]
  (if (same-size-strands? strand1 strand2)
    (let [strand1 (seq strand1)
        strand2 (seq strand2)]
      (diff strand1 strand2 0))
    (throw (IllegalArgumentException. "strands must be of equal length"))))
