(ns triangle)

(defn triangle-inequality
  [a b c]
  (or (< (+ a c) b) (< (+ a b) c) (< (+ b c) a)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral;
  otherwise, it returns false."
  [a b c]
  (if (zero? a)
    false
    (= a b c)))

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles;
  otherwise, it returns false."
  [a b c]
  (if (triangle-inequality a b c)
    false
    (cond
      (= a b) true
      (= b c) true
      (= a c) true
      :else false)))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene;
  otherwise, it returns false."
  [a b c]
  (if (triangle-inequality a b c)
    false
    (not (isosceles? a b c))))
