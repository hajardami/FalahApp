import {createTheme} from "@mui/material/styles"

export const Colors = {
    primary : "#007155",
    dark_grey: "#A6A6A6",
    light_grey: "#F5F5F5",
    white: "#FFFFFF"

}

const theme = createTheme({
    palette: {
        primary :{
            main : Colors.primary,
            light: Colors.white
        },
        neutral: {
            main: Colors.white
        },
        darkgrey :{
            main: Colors.dark_grey,
        },
        lightgrey: {
            main: Colors.light_grey
        },
        white: {
            main: Colors.white
        }
    },

    typography: {
        fontFamily: ["Space Grotesk"].join(","),
        fontSize: 16,
        
       }
})

export default theme