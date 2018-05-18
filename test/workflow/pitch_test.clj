(ns workflow.pitch-test
  (:require [clojure.test          :refer (deftest testing is)]
            [workflow.test-helpers :refer (=ish round)]
            [workflow.pitch        :as    pitch]))

(deftest conversion-tests
  (testing "conversions:"
    (testing "MIDI note -> frequency"
      (is (=ish (pitch/midi->hz 0) 8.176))       ; C-1
      (is (=ish (pitch/midi->hz 21) 27.5))       ; A0
      (is (=ish (pitch/midi->hz 27) 38.891))     ; Eb1
      (is (=ish (pitch/midi->hz 43) 97.999))     ; G2
      (is (=ish (pitch/midi->hz 57) 220))        ; A3
      (is (=ish (pitch/midi->hz 60) 261.63))     ; C4
      (is (=ish (pitch/midi->hz 69) 440))        ; A4
      (is (=ish (pitch/midi->hz 72) 523.25))     ; C5
      (is (=ish (pitch/midi->hz 73) 554.37))     ; C#5
      (is (=ish (pitch/midi->hz 74) 587.33))     ; D5
      (is (=ish (pitch/midi->hz 90) 1479.98))    ; F#6
      (is (=ish (pitch/midi->hz 100) 2637.02))   ; E7
      (is (=ish (pitch/midi->hz 108) 4186))      ; C8
      (is (=ish (pitch/midi->hz 125) 11175.3))   ; F9
      (is (=ish (pitch/midi->hz 127) 12543.85))) ; G9
    (testing "frequency -> the nearest MIDI note"
      (is (= (pitch/hz->midi 7.95) 0))
      (is (= (pitch/hz->midi 8.176) 0))
      (is (= (pitch/hz->midi 25.96) 20))
      (is (= (pitch/hz->midi 26) 20))
      (is (= (pitch/hz->midi 107.3) 45))
      (is (= (pitch/hz->midi 261) 60))
      (is (= (pitch/hz->midi 430) 69))
      (is (= (pitch/hz->midi 439) 69))
      (is (= (pitch/hz->midi 440) 69))
      (is (= (pitch/hz->midi 441) 69))
      (is (= (pitch/hz->midi 8372) 120)))))

