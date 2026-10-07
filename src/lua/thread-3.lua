local lanes = require("lanes").configure({
    demote_full_userdata = true
})

local function trabalhador(numero, tempo_trabalho)
    print("Trabalhador " .. numero .. " começou")

    local lanes_thread = require("lanes")
    lanes_thread.sleep(tempo_trabalho)

    print("Trabalhador " .. numero .. " terminou (levou " .. tempo_trabalho .. "s)")
end

print("Iniciando 5 trabalhadores...")

local threads = {}

local criar_thread = lanes.gen("*", trabalhador)

for i = 0, 4 do
    local thread = criar_thread(i, 2)
    table.insert(threads, thread)
end

for _, thread in ipairs(threads) do
    thread:join()
end

print("\nTodos os trabalhadores terminaram!")

print("\nTodos os trabalhadores terminaram!")