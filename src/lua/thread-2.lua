local lanes = require("lanes").configure()

local function saudar(nome, vezes)
    for i = 1, vezes do
        print("Olá, " .. nome .. "! (mensagem " .. i .. ")")
    end
end

local criar_thread = lanes.gen("*", saudar)

local thread = criar_thread("Maria", 3)

thread:join()