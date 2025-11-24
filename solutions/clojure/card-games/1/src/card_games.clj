(ns card-games)

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (let [second (inc n)
        third (inc second)]
    (seq [n second third])))

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (boolean (some #(= % n) l)))

(defn card-average
  "Returns the average value of a hand"
  [hand]
  (let [hand-size (count hand)
        hand-sum (reduce + hand)]
    (float (/ hand-sum hand-size))))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the first and last number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [avg      (/ (reduce + hand) (count hand))
        edge-avg (/ (+ (first hand) (last hand)) 2)
        middle   (nth hand (quot (count hand) 2))]
    (or (= avg edge-avg)
        (= avg middle))))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [even-nums (filter even? hand)
        odd-nums  (filter odd? hand)]
    (if-let [valid? (and (pos? (count even-nums))
                         (pos? (count odd-nums)))]
      (let [even-sum     (reduce + even-nums)
            odd-sum      (reduce + odd-nums)
            even-average (/ even-sum (count even-nums))
            odd-average  (/ odd-sum (count odd-nums))]
        (= even-average odd-average))
      true)))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= 11 (last hand))
    (conj (vec (butlast hand)) (* 2 (last hand)))
    hand))