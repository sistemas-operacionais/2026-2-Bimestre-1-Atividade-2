local lanes = require("lanes").configure({
    demote_full_userdata = true
})

local function minha_funcao()
    print("Thread iniciada!")
    print("Thread finalizada!")
end

local criar_thread = lanes.gen("*", minha_funcao)

local thread = criar_thread()

thread:join()

print("Programa principal finalizado!")