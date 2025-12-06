(ns bank-account)

(defn open-account []
  (atom {:balance 0}))

(defn close-account [account]
  (swap! account assoc :balance nil))

(defn get-balance [account]
  (:balance @account))

(defn update-balance [account new-balance]
  (swap! account update :balance #(+ % new-balance)))
