(ns workflow.pitch
  "Library functions for converting between MIDI note and frequency in Hz.")

(def ^:const REFERENCE-PITCH 440.0)

(defn midi->hz
  "Converts a MIDI note (0-127) to its frequency in Hz.

   To keep things simple, the tuning system is equal temperament and the
   reference pitch is A440 (440 Hz)."
  [midi-note]
  {:pre  [(integer? midi-note)]
   :post [(not (neg? %))]}
  (* REFERENCE-PITCH (Math/pow 2 (/ (- midi-note 69) 12.0))))

(defn hz->midi
  "Converts a frequency in Hz to the closest MIDI note.

   Reference pitch is A440 by default. To calculate pitch based on an alternate
   reference pitch (e.g. A430), set or bind *reference-pitch* to the frequency
   of A4.

   Tuning system is equal temperament by default. To calculate pitch based on
   an alternate tuning system (e.g. well temperament), set or bind
   *tuning-system* to a valid keyword representing that tuning system."
  [freq]
  {:pre  [(number? freq) (pos? freq)]
   :post [(not (neg? %))]}
  (letfn [(log2 [n] (/ (Math/log n) (Math/log 2)))]
    (Math/round (+ 69 (* 12 (log2 (/ freq REFERENCE-PITCH)))))))

