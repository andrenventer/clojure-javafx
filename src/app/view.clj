(ns app.view
  (:gen-class
   :name app.view.Main
   :prefix view-
   :methods [[loadFxml [] javafx.scene.Parent]])
  (:import (javafx.scene Parent))
  (:use [app.jfx]))

(defn view-loadFxml [this]
  "Load the FXML and create a view for display in a parent"
  (let [root (fx-load-fxml "window.fxml")
        DisplayLabel (.lookup root "#DisplayLabel")
        ButtonAllClear (.lookup root "#ButtonAllClear")
        LeftBracket (.lookup root "#LeftBracket")
        RightBracket (.lookup root "#RightBracket")
        ButtonDivide (.lookup root "#ButtonDivide")
        ButtonMultiply (.lookup root "#ButtonMultiply")
        ButtonMinus (.lookup root "#ButtonMinus")
        ButtonPlus (.lookup root "#ButtonPlus")
        ButtonEquals (.lookup root "#ButtonEquals")
        ButtonUndo (.lookup root "#ButtonUndo")
        Button0 (.lookup root "#Button0")
        Button1 (.lookup root "#Button1")
        Button2 (.lookup root "#Button2")
        Button3 (.lookup root "#Button3")
        Button4 (.lookup root "#Button4")
        Button5 (.lookup root "#Button5")
        Button6 (.lookup root "#Button6")
        Button7 (.lookup root "#Button7")
        Button8 (.lookup root "#Button8")
        Button9 (.lookup root "#Button9")]

    (def calculation (atom []))

    (defn allClear []
      (reset! calculation [])
      (.setText DisplayLabel ""))

    (defn display [character]
      (swap! calculation conj character)
      (.setText DisplayLabel
         (apply str (seq (deref calculation)))))

    (defn undo []
      (swap! calculation pop)
      (.setText DisplayLabel
         (apply str (seq (deref calculation)))))

    (defn tokenize [expr]
      (let [to-chars #(clojure.string/split (clojure.string/replace % " " "") #"")
            is-digit? #(and % (re-find #"^\d+$" %))]
        (reverse
          (reduce
            (fn [[t & ts :as tokens] token]
              (if (and (is-digit? token) (is-digit? t))
                (cons (str t token) ts)
                (cons token tokens)))
            '(), (to-chars expr)))))

    (defn shunting-yard [tokens]
      (let [ops {"+" 1, "-" 1, "*" 2, "/" 2}]
        (flatten
          (reduce
            (fn [[rpn stack] token]
              (let [less-op? #(and (contains? ops %) (<= (ops token) (ops %)))
                    not-open-paren? #(not= "(" %)]
                (cond
                  (= token "(") [rpn (cons token stack)]
                  (= token ")") [(vec (concat rpn (take-while not-open-paren? stack))) (rest (drop-while not-open-paren? stack))]
                  (contains? ops token) [(vec (concat rpn (take-while less-op? stack))) (cons token (drop-while less-op? stack))]
                  :else [(conj rpn token) stack])))
            [[] ()]
            tokens))))

    (defn rpn [tokens]
      (let [ops {"+" +, "-" -, "*" *, "/" /}]
        (first
          (reduce
            (fn [stack token]
              (if (contains? ops token)
                (cons ((ops token) (second stack) (first stack)) (drop 2 stack))
                (cons (read-string token) stack)))
            [] tokens))))

    (def log #(do (println %) %))

    (def calc (comp rpn shunting-yard tokenize))

    (def calc-debug (comp rpn log shunting-yard log tokenize))

    (defn compute []
      (.setText DisplayLabel
          (str (calc (apply str (seq (deref calculation)))))))

(comment

  (swap! calculation conj '-)
  (apply str (seq (deref calculation)))
  (swap! calculation pop)
  (calc (apply str (seq (deref calculation))))
  (str (calc-debug (apply str (seq (deref calculation)))))

 )

    (fx-action ButtonAllClear
               (do
                 (allClear)))

    (fx-action LeftBracket
               (do
                 (display "(" )))

    (fx-action RightBracket
               (do
                 (display ")" )))

    (fx-action ButtonDivide
               (do
                 (display '/)))

    (fx-action ButtonMultiply
               (do
                 (display '*)))

    (fx-action ButtonMinus
               (do
                 (display '-)))

    (fx-action ButtonPlus
               (do
                 (display '+)))

    (fx-action ButtonEquals
               (do
                 (compute)))

    (fx-action ButtonUndo
               (do
                 (undo)))

    (fx-action Button0
               (do
                 (display '0)))

    (fx-action Button1
               (do
                 (display '1)))

    (fx-action Button2
               (do
                 (display '2)))

    (fx-action Button3
               (do
                 (display '3)))

    (fx-action Button4
               (do
                 (display '4)))

    (fx-action Button5
               (do
                 (display '5)))

    (fx-action Button6
               (do
                 (display '6)))

    (fx-action Button7
               (do
                 (display '7)))

    (fx-action Button8
               (do
                 (display '8)))

    (fx-action Button9
               (do
                 (display '9)))

    root))
