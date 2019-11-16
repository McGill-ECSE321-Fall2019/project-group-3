  export default {
    data() {
      return {
        size_selected: null,
        size_options: [
          { value: null, text: 'Please select an option' },
          { value: 'BIG', text: 'BIG' },
		  { value: 'SMALL', text: 'SMALL' }],
		  form: {
				numberOfSeats: "1",
				startTime: "",
                endTime: "",
				lesson: null,
            }
        
      }
    }
  }