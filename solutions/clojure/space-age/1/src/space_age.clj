(ns space-age)

(defn on-earth
  "Returns someone's age on Earth based on the given age in seconds."
  [seconds]
  (/ seconds 31557600))

(defn apply-planet-orbit-period
  [seconds orbital-period]
  (->
    seconds
    on-earth
    (/ orbital-period)))

(defn on-mercury
  "Returns someone's age on Mercury based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 0.2408467))

(defn on-venus
  "Returns someone's age on Venus based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 0.61519726))

(defn on-mars
  "Returns someone's age on Mars based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 1.8808158))

(defn on-jupiter
  "Returns someone's age on Jupiter based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 11.862615))

(defn on-saturn
  "Returns someone's age on Saturn based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 29.447498))

(defn on-uranus
  "Returns someone's age on Uranus based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 84.016846))

(defn on-neptune
  "Returns someone's age on Neptune based on the given age in seconds."
  [seconds]
  (apply-planet-orbit-period seconds 164.79132))
