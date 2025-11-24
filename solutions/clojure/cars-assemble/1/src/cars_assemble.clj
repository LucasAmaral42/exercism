(ns cars-assemble)

(defn calculate-production [speed]
  (* speed 221))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (cond 
    (== speed 0)
      0
    (<= 1 speed 4)
      (calculate-production speed)
    (<= 5 speed 8)
      (* (calculate-production speed) 0.9)
    (== speed 9)
      (* (calculate-production speed) 0.8)
    (== speed 10)
      (* (calculate-production speed) 0.77)
    )
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
