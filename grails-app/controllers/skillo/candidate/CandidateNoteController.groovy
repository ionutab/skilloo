package skillo.candidate

class CandidateNoteController {

	def scaffold = true

    def index() {
        redirect(action: "list")
    }
}
