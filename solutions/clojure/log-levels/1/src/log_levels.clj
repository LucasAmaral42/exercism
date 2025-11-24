(ns log-levels
  (:require [clojure.string :as str]))

(defn replace
  "Takes the string and replace with regex pattern and trim"
  [s, pattern]
  (-> s
   (str/replace pattern "")
   str/trim)
  )

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (replace s #"^\[.+\]:\s*")
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (-> s
    (replace #"^\[|\]|(:.*)")
    str/lower-case)
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (format "%s (%s)" (message s) (log-level s))
  )
