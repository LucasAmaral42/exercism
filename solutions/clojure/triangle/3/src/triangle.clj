(ns triangle)

(defn valid-triangle?
  [a b c]
  (and  (> (+ a c) b) (> (+ a b) c) (> (+ b c) a)))

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral;
  otherwise, it returns false."
  [a b c]
  (and (every? #(> % 0) [a b c]) (= a b c)))

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles;
  otherwise, it returns false."
  [a b c]
  (and (valid-triangle? a b c)
       (or (= a b) (= b c) (= a c))))

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene;
  otherwise, it returns false."
  [a b c]
  (and (valid-triangle? a b c)
       (distinct? a b c)))
