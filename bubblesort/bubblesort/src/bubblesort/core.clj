(ns bubblesort.core
  (:gen-class))

(defn step            ;the swap recurrence
     [opr arr changed];the flag for position
     (if (< (count arr) 2);if only one element, the loop ends
       [arr (not changed)] ;the flag here is for the loop not for swapping,
                             ;if the value of element changed,the value is true
                             ;and it means the loop doesn't finish
       (let [[ x1 x2 & other] arr
             first-smaller (opr x1 x2);whether the element need change the position
             is-changed (or changed (not first-smaller));the last loop and the current loop
                                                            ;wheter the element change the position
             [smaller larger] (if first-smaller [x1 x2] [x2 x1]);change the position of telements
             [result is-sorted] (step opr (cons larger other) is-changed)];the tag element
                             ;and the remaining elements will continue the next loop
                             ; and the flag of the position will pass to the next
            [(cons smaller result) is-sorted])))
(defn bubble-sort    ;bubbling sorting
     ([arr] (bubble-sort <= arr))
     ([opr arr]
     (let [[result is-sorted] (step opr arr false)]
       (if is-sorted
         result
         (recur opr result)))))
(bubble-sort [4,1,9,2,8,5])

(bubble-sort > [4,1,9,2,8,5])



