1-

(defn executar-thread [id]
      (Thread.
        (fn []
            (println "Thread" id "iniciada!")
            (doseq [numero (range 1 6)]
                   (println "Thread" id "- Número:" numero)
                   (Thread/sleep 500))
            (println "Thread" id "finalizada!"))))

(defn main []
      (let [thread1 (executar-thread 1)
            thread2 (executar-thread 2)
            thread3 (executar-thread 3)]

           (.start thread1)
           (.start thread2)
           (.start thread3)

           (.join thread1)
           (.join thread2)
           (.join thread3)

           (println "Programa finalizado!")))

(main)

2- 

(defn tempo-aleatorio []
      (+ 200 (rand-int 801)))

(defn criar-corredor [id]
      (Thread.
        (fn []
            (println "Corredor" id "começou a corrida!")

            (doseq [metro (range 1 11)]
                   (Thread/sleep (tempo-aleatorio))
                   (println "Corredor" id "chegou ao metro" metro))

            (println "Corredor" id "terminou a corrida!"))))

(defn main []
      (let [corredor1 (criar-corredor 1)
            corredor2 (criar-corredor 2)
            corredor3 (criar-corredor 3)
            corredor4 (criar-corredor 4)]

           (.start corredor1)
           (.start corredor2)
           (.start corredor3)
           (.start corredor4)

           (.join corredor1)
           (.join corredor2)
           (.join corredor3)
           (.join corredor4)

           (println "Corrida finalizada!")))

(main)

(ns atv3)

(defn worker
  [numero tempo_trabalho]
  (future
    (println (str "trabalhador" numero "comeÃ§ou"))
    (Thread/sleep (* tempo_trabalho  1000))
    (println (str "trabalhador" numero "terminou (levou" tempo_trabalho "s)"))))



(defn main []
  (println "Iniciando 5 trabalhadores...")
  (let [inicio (System/currentTimeMillis)
        futuros (mapv (fn [i] (future (worker i 2)))
                      (range 5))]
    (doseq [f futuros] @f)
    (let [fim ( System/currentTimeMillis)
          tempo-total (/ (- fim inicio) 1000.0)]
      (println "\nTodos os trabalhadores terminaram!")
      (println (format "Tempo total: %.2fs" tempo-total))
      (println "(se fosse sequencial, levaria 0s)")))
  (shutdown-agents))

(main)