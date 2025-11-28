(ns word-count
  (:require [clojure.string :as str]))

(defn trim-word
  [word]
  (str/replace word #"^'|'$" ""))

(defn clean
  [s]
  (->
    s
    (str/replace #"[^a-zA-Z0-9']|^'|'$" " ")
    (str/trim)
    (str/lower-case)))

(defn update-word-count
  [word-count word]
  (let [word (trim-word word)]
    (if (contains? word-count word)
      (update word-count word inc)
      (assoc word-count word 1))))

(defn word-count
  "Counts how many times each word occurs in the given string."
  [s]
  (let [clean-string (clean s)
        split-words (str/split clean-string #"\s+")]
    (reduce update-word-count {} split-words)))
