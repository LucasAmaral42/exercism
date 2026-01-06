(ns pangram
  (:require [clojure.string :as str]))

(defn count-letters
  [s]
  (-> s
    (str/lower-case)
    (str/replace #"[^a-z]" "")
    (frequencies)
    (keys)
    (count)))

(defn pangram?
  "Returns true if the given string is a pangram;
  otherwise, it returns false."
  [s]
  (= 26 (count-letters s)))
