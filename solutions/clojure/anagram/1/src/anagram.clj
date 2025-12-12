(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for
  "Returns all words from candidates that are anagrams of the given word."
  [word candidates]
  (let [word-lower (str/lower-case word)
        word-freq (frequencies word-lower)]
    (filter #(let [candidate-lower (str/lower-case %)]
               (and (not= word-lower candidate-lower)
                    (= word-freq (frequencies candidate-lower))))
            candidates)))