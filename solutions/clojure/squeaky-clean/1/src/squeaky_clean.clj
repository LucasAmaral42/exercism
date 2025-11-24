(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn capitalize-first
  [string]
  (if (empty? string)
    ""
    (str (str/upper-case (first string)) (subs string 1))))

(defn kebab-to-camel-case
  [string]
  (let [[first & rest] (str/split string #"-")]
    (->
     (map #(capitalize-first %) rest)
     (conj first)
     (str/join))))

(defn clean
  "TODO: add docstring"
  [s]
  (->
   s
   (kebab-to-camel-case)
   (str/replace #"\s" "_")
   (str/replace #"\p{Cc}" "CTRL")
   (str/replace #"[^\p{L}\p{M}_]+" "")
   (str/replace #"[α-ω]" "")))
