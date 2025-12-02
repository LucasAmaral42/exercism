(ns complex-numbers
  (:require [clojure.math :as math]))

(defn real [[a b]] ;; <- arglist goes here
  a)

(defn imaginary [[a b]] ;; <- arglist goes here
  b)

(defn abs [[a b]] ;; <- arglist goes here
  (let [a (* a a)
        b (* b b)]
    (->
      (+ a b)
      math/sqrt)))

(defn conjugate [[a b]] ;; <- arglist goes here
  [a (- b)])

(defn add [[a b] [c d]] ;; <- arglist goes here
  (let [sum-real      (+ a c)
        sum-imaginary (+ b d)]
    [sum-real sum-imaginary]))

(defn sub [[a b] [c d]] ;; <- arglist goes here
  (let [sub-real      (- a c)
        sub-imaginary (- b d)]
    [sub-real sub-imaginary]))

(defn mul [[a b] [c d]] ;; <- arglist goes here
  (let [multi-part-1 (- (* a c) (* b d))
        multi-part-2 (+ (* b c) (* a d))]
    [multi-part-1 multi-part-2]))

(defn div [[a b] [c d]] ;; <- arglist goes here
  (let [multi-part-1 (+ (* a c) (* b d))
        multi-part-2 (- (* b c) (* a d))
        pow          (+ (* c c) (* d d))
        div-part-1   (/ multi-part-1 pow)
        div-part-2   (/ multi-part-2 pow)]
    [div-part-1 div-part-2]))
