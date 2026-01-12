(ns grade-school)

(defn grade [school grade]
    (get school grade []))

(defn add [school name grade]
  (if (empty? (get school grade))
    (assoc school grade [name])
    (update school grade conj name)))

(defn sorted [school]
    (->>
      school
      (reduce (fn [acc [key val]] (assoc acc key (sort val))) {})
      sort
      (into {})))
