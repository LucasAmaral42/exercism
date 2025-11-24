(ns rna-transcription)

(defn replace-nucleotide
  [nucleotide]
  (cond
    (= nucleotide \G) \C
    (= nucleotide \C) \G
    (= nucleotide \T) \A
    (= nucleotide \A) \U))

(defn to-rna
  "Returns the RNA complement of the given DNA string sequence."
  [dna]
  (reduce #(str %1 (replace-nucleotide %2)) "" dna))
