import { createTheme, ThemeProvider } from "@mui/material/styles";

import ListCoach from "./ListCoach"
function DocVerification() {
    const styles = {
        appBody: {
          minHeight: "100vh",
          backgroundColor: "#BBD4CE",
          backgroundPosition: "top",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
          boxShadow: "inset 0 0 0 1000px rgba(255,255,255,.5)",
        },
      };
      
      const theme = createTheme({
        typography: {
          
          fontSize: 15,
          button: {
            textTransform: "none",
          },
        },
        palette: {
          primary: {
            main: "#007155",
          },
          secondary: {
            main: "#6495ED",
          },
          grey: {
            main: "#8C92AC",
          },
        },
      });
    return (
      <ThemeProvider theme={theme}>
      
          <div style={styles.appBody}>  <ListCoach/>
       


        </div>
      </ThemeProvider>
    );
  }
  export default DocVerification;