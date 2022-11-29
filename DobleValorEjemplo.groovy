class DobleValor {
	def valor

	// Setter puede obviarse si solo va a setear el valor
	void setValor(valor){
		this.valor = valor
	}

	def getValor(){
		valor * 2
	}
}

def doble = new DobleValor(valor: 300)
assert 600 == doble.getValor()
assert 600 == doble.valor

println("Valor doble: ${doble.getValor()}")

assert 300 == doble.@valor

println("Valor original: ${doble.@valor}")
